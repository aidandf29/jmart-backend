package com.aidanJmartBO;
import java.util.Date;

import com.aidanJmartBO.dbjson.Serializable;

import java.util.ArrayList;


/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Invoice extends Serializable
{
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    public Status status;
    
    
    public enum Rating 
    {
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }

    public enum Status 
    {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        DELIVERED,
        COMPLAINT,
        FINISHED,
        FAILED;
    }
    
    public abstract double getTotalPay(Product product);
    
    class Record{
        public Date date;
        public String message;
        public Status status;
    }
    
    protected Invoice(int buyerId, int productId) 
    {
        
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
    }
    
}
