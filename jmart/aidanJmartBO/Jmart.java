package aidanJmartBO;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Jmart
{
    public static void main (String args[]) {
        
        //create();
                
    }
    
    //public static Product create() {
    //   return new Product("FIFA 20", 20, true, new PriceTag(100000.0), ProductCategory.GAMING);
    //
    
    public static Product createProduct() {
        return null;
    }
    
    public static Coupon createCoupon() {
        return null;
    }
    
    public static ShipmentDuration createShipmentDuration(){
        return (new ShipmentDuration(ShipmentDuration.INSTANT, ShipmentDuration.KARGO));
    }

}