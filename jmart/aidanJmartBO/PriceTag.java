package aidanJmartBO;


/**
 * Write a description of class PriceTag here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PriceTag
{
    final public static double COMMISSION_MULTIPLIER= 0.05;
    final public static double BOTTOM_PRICE = 20000.0;
    final public static double BOTTOM_FEE = 1000.0 ;
    public double  discount;
    public double price;
    
    public PriceTag(double price){
        this.price = price;
        this.discount = 0.0;
    }
    public PriceTag(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
    
    public double getAdminFee(){
        if (this.getDiscountedPrice() < BOTTOM_PRICE) {
            return BOTTOM_FEE;
        }
        else {
            return getDiscountedPrice() * ( 1- COMMISSION_MULTIPLIER);
        }
    }
    
    public double getDiscountedPrice(){
        if (this.discount >= 100) {
            this.price = 0.0;
            return this.price;
        }
        else {
            return price - (price * discount);
        }
    }
}
