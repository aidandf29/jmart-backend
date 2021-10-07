package aidanJmartBO;
import java.util.Date;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Jmart
{
    public static void main (String args[]) 
    {
    	System.out.print("Hello from Eclipse");
    	
//        System.out.println(Shipment.Duration.INSTANT.getEstimatedArrival(new Date()));
//        Store store = new Store (99, "Muh Aidan", "Depok", "08577824567");
//        //System.out.println(store.validate());
//        Account account = new Account(1, "Aidan", "aidan@ui.ac.id", "Aidan123");
//        System.out.println(account.validate());
                
    }
    
    //public static Product create() {
    //   return new Product("FIFA 20", 20, true, new PriceTag(100000.0), ProductCategory.GAMING);
    //
    
    public static Product createProduct()
    {
        //Product productLaptop = new Product("Laptop", 3, false, new PriceTag(4000000,10), ProductCategory.ELECTRONIC);
        return null;
    }
    public static Coupon createCoupun()
    {
        return null;
        //return new Coupon("Kupon Discount 50%", 1, Coupon.Type.DISCOUNT, 40, 15000);
    }
    public static Shipment.Duration createShipmentDuration()
    {
        //return new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.SAME_DAY);
        return null;
    }

}