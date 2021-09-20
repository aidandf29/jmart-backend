package aidanJmartBO;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    public static enum Type {
        DISCOUNT,
        REBATE;
    }
    
    final public String name;
    final public int code;
    final public double cut;
    final public Type type;
    final public double minimum;
    private boolean used = false;
     
     public Coupon(String name,int code,Type type,double cut,double minimum) { 
         
         this.name = name;
         this.code = code;
         this.type = type;
         this.cut = cut;
         this.minimum = minimum;

     }
     
     public boolean isUsed() {
         return this.used;
     }
     
     public boolean canApply(PriceTag priceTag) {
         if (priceTag.getAdjustedPrice() >= minimum && used == false) {
             return true;
         }
         else {
             return false;
         }
     }
     
     public double apply(PriceTag priceTag) {
         if (type == Type.DISCOUNT) {
             return (priceTag.getAdjustedPrice() * (100 - this.cut) / 100);
         }
         else {
             return (priceTag.getAdjustedPrice() - this.cut);
         }
     }  
    
}
