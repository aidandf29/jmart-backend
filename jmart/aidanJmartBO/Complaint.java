package aidanJmartBO;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Transaction implements FileParser
{
    public int paymentId;
    public String desc;
    
    public Complaint(int id, Payment payment, String desc)
    {
        
    }
    
    public Complaint(int id, int buyerId, int storeId, int paymentId, String desc)
    {
        
    }
    
    @Override
    public boolean read(String content) 
    {
        return false;
    }
    
    @Override
    public boolean validate() 
    {
        return false;
    }
    
    @Override
    public boolean Transaction() 
    {
        return null;
    }
    
    
}
