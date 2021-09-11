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
        
        System.out.println(getPromo());
        System.out.println(getCustomer());
        System.out.println(getDiscountPercentage(1000, 900));
        System.out.println(getDiscountedPrice(1000, 10.0f));
        System.out.println(getOriginalPrice(900, 10.0f));
        System.out.println(getCommissionMultiplier());
        System.out.println(getAdjustedPrice(1000));
        System.out.println(getAdminFee(1000));
        
    }
    
    public static int getPromo() {
        return 0;
    }
    
    public static String getCustomer() {
        return "oop";
    }
        
    public static float getDiscountPercentage(int before, int after){
        
        if (before < after) {
            return 0.0f;
        }
        else{
            return (float) (before - after) / before*100;
        }
        
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100.0f) {
            return 0;
        }
        else{
            float floatPrice = (float) price;
            return (int) (floatPrice - (floatPrice * discountPercentage / 100));
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        float floatdiscountedPrice = (float) discountedPrice;
        return (int) (floatdiscountedPrice * (100 / (100-discountPercentage)));
        
    }
    
    public static float getCommissionMultiplier() {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price) {
        float floatPrice = (float) price;
        return (int) (floatPrice + (floatPrice * getCommissionMultiplier()));
    }
    
    public static int getAdminFee(int price) {
        float floatprice = (float) price;
        return (int) (floatprice * getCommissionMultiplier());
    }
}