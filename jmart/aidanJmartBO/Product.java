package aidanJmartBO;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Recognizable
{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeId;
    public Shipment.MultiDuration multiDuration;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed,PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration)
    {
        
        this.storeId = storeId;
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.rating = new ProductRating();
        this.category = category;
        this.multiDuration = multiDuration;
    }

    @Override
    public String toString()
    {
        return "Name: " + this.name + " \n"+
        "Weight: " + this.weight +" \n"+
        "ConditionUsed: " + this.conditionUsed + " \n" +
        "PriceTag: "+ this.priceTag.price +" \n" +
        "Category: "+ this.category +" \n" +
        "Rating: "+ this.rating.getAverage() +" \n"+
        "StoreId: "+ this.storeId +" \n";
    }
}
