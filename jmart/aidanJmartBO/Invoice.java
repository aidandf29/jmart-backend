package aidanJmartBO;
import java.util.Date;
import java.util.ArrayList;

/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable
{
    public final Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    public ArrayList<Record> history;
    
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
        COMPLAINT,
        FINISHED,
        FAILED;
    }
    
    public abstract double getTotalPay();
    
    protected Invoice(int id, int buyerId, int productId) 
    {
        
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
        this.buyerId = buyerId;
        this.productId = productId;
        this.date = new Date();
    }
    
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
}
