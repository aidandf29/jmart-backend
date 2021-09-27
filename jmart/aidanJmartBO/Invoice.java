package aidanJmartBO;


/**
 * Abstract class Invoice - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Invoice extends Recognizable implements FileParser
{
    public String date = "16 Mei 2001";
    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating = Rating.NONE;
    public Status status = Status.WAITING_CONFIRMATION;
    
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
        super(id);
        date = "29 Mei 2001";
        rating = Rating.NONE;
        status = Status.WAITING_CONFIRMATION;
        this.buyerId = buyerId;
        this.productId = productId;
    }
    
    
    @Override
    public boolean read(String content) 
    {
        return false;
    }
}
