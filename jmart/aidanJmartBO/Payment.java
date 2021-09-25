package aidanJmartBO;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Transaction implements FileParser
{
    public int productId;
    public ShipmentDuration shipmentDuration;
    
    
    public Payment(int id, int buyerId, Product product, ShipmentDuration shipmentDuration)
    {
        super(id, 0, 0);
    }
    
    public Payment(int id, int buyerId, int storeId, int productId, ShipmentDuration shipmentDuration)
    {
      super(id, 0, 0);  
    }
    
    @Override
    public boolean read(String content){
        return false;
    }

    public boolean validate(){
        return false;
    }

    public Transaction perform(){
        return null;
    }
    

}
