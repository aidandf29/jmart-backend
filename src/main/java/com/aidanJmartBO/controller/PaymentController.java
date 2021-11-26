package com.aidanJmartBO.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.Account;
import com.aidanJmartBO.Invoice;
import com.aidanJmartBO.ObjectPoolThread;
import com.aidanJmartBO.Payment;
import com.aidanJmartBO.Product;
import com.aidanJmartBO.dbjson.JsonAutowired;
import com.aidanJmartBO.dbjson.JsonTable;


@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {

	@JsonAutowired(filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\src\\main\\java\\com\\randomPaymentList.json", value = Payment.class)
	public static JsonTable<Payment> paymentTable;
	public static ObjectPoolThread<Payment> poolThread = new ObjectPoolThread<Payment>(PaymentController::timekeeper);
	
	public static final long DELIVERED_LIMIT_MS = 1;
    public static final long ON_DELIVERIY_LIMIT_MS = 1;
    public static final long ON_PROGRESS_LIMIT_MS = 1;
    public static final long WAITING_CONF_LIMIT_MS = 1;
    
	
    @PostMapping("/{id}/accept")
    boolean accept(@RequestParam int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.ON_PROGRESS, "ON_PROGRESS"));
                    return true;
                }
            }
        }
        return false;
    }

    @PostMapping("/{id}/cancel")
    boolean cancel(@PathVariable int id) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.WAITING_CONFIRMATION){
                    payment.history.add(new Payment.Record(Invoice.Status.CANCELLED, "CANCELLED"));
                    return true;
                }
            }
        }
         return false;
    }

    @PostMapping("/create")
    Payment create(@RequestParam int buyerId, @RequestParam int productId, @RequestParam int productCount, @RequestParam String shipmentAddress, @RequestParam byte shipmentPlan) {
        for(Account account : AccountController.accountTable){
            if(account.id == buyerId){
                for(Product product : ProductController.productTable){
                    if(product.accountId == productId){
                        Payment newPayment = new Payment(buyerId, productId, productCount, new Shipment(shipmentAddress, 0, shipmentPlan, null));
                        double paytotal = newPayment.getTotalPay(product);
                        if(account.balance >= paytotal){
                            account.balance -= paytotal;
                            newPayment.history.add(new Payment.Record(Invoice.Status.WAITING_CONFIRMATION, "WAITING_CONFIRMATION"));
                            paymentTable.add(newPayment);
                            poolThread.add(newPayment);
                            return newPayment;
                        }
                    }
                }
            }
        }
        return null;
    }

    @PostMapping("/{id}/submit")
    boolean submit(@PathVariable int id, String receipt) {
        for(Payment payment : paymentTable){
            if(payment.id == id){
                if(payment.history.get(payment.history.size() - 1).status == Invoice.Status.ON_PROGRESS){
                    if(!payment.shipment.receipt.isBlank()){
                        payment.shipment.receipt = receipt;
                        payment.history.add(new Payment.Record(Invoice.Status.ON_DELIVERY, "ON_DELIVERY"));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static Boolean timekeeper(Payment payment) {
        if (payment.history.size() == 0) {
            return true;
        } else {
            Payment.Record record = payment.history.get(payment.history.size() - 1);
            long elapsed = System.currentTimeMillis() - record.date.getTime();
            if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.FAILED;
                return true;
            } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
                record.status = Invoice.Status.DELIVERED;
                return true;
            } else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
                record.status = Invoice.Status.FINISHED;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
}