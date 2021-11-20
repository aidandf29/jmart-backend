package com.aidanJmartBO;
import java.util.ArrayList;
import java.util.Date;

import com.aidanJmartBO.dbjson.JsonAutowired;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
	
	
    public int productCount;
    public Shipment shipment;
    public ArrayList<Record> history = new ArrayList<>();
    
    public Payment(int buyerId, int productId, int productCount, Shipment shipment) 
    {
        super(buyerId, productId);
        this.productCount = productCount;
        this.shipment = shipment;
    }

    @Override
    public double getTotalPay(Product product) 
    {
    	return (productCount * Treasury.getAdjustedPrice(product.price, product.discount));
    }
    
    public  static class Record {
        public final Date date;
        public String massage;
        public Status status;


        public Record( Status status, String massage) {
            this.date = new Date();;
            this.status = status;
            this.massage = massage;
        }

    }

}
