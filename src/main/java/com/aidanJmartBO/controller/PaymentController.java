package com.aidanJmartBO.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.ObjectPoolThread;
import com.aidanJmartBO.Payment;
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
    boolean accept(int id) {
        return false;
    }
    @PostMapping("/{id}/cancel")
    boolean cancel(int id) {
        return false;
    }
    @PostMapping("/{id}/submit")
    boolean submit(int id) {
        return false;
    }
    @PostMapping("/create")
    Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return null;
    }
    
    private static boolean timekeeper(Payment payment) {
    	return false;
    }
    
	@Override
	public JsonTable<Payment> getJsonTable() {
		return null;
	}

}