package com.aidanJmartBO.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.ObjectPoolThread;
import com.aidanJmartBO.Payment;
import com.aidanJmartBO.dbjson.JsonTable;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>{

	public static final long DELIVERED_LIMIT_MS = 0;
    public static final long ON_DELIVERIY_LIMIT_MS = 0;
    public static final long ON_PROGRESS_LIMIT_MS = 0;
    public static final long WAITING_CONF_LIMIT_MS = 0;
    public static JsonTable<Payment> paymentTable;
    public static ObjectPoolThread<Payment> poolThread;
	
    @PostMapping("/{id}/accept")
    public boolean accept(int id) {
    	return false;
    }
    @PostMapping("/{id}/cancel")
    public boolean cancel(int id) {
    	return false;
    }
    @PostMapping("/submit")
    public boolean submit(int id, String receipt) {
    	return false;
    }
    @PostMapping("/create")
    public Payment create(int buyerId, int productId, int productCount, String shipmentAddress, byte shipmentPlan) {
        return null;
    }
    
    public JsonTable<Payment> getJsOnTable() {
    	return null;
    }
    private static boolean timekeeper(Payment payment) {
    	return false;
    }
	
	@Override
	public JsonTable<Payment> getJsonTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
