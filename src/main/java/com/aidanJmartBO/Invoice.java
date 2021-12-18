package com.aidanJmartBO;
import java.util.Date;

import com.aidanJmartBO.dbjson.Serializable;

import java.util.ArrayList;


/**
 * Invoice class is blueprint code for invoice
@author Muh. Aidan Daffa
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
    
    //enum for status
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
    
    protected Invoice(int buyerId, int productId) 
    {
        
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
        this.complaintId = -1;
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
    }
    
}
