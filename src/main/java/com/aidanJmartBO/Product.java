package com.aidanJmartBO;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product extends Serializable
{
    public String name;
    public int weight;
    public boolean conditionUsed;
    public ProductCategory category;
    public double discount;
    public double price;
    public byte shipmentPlans;
    public int accountId;

    public Product(int accountId, String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans)
    {
        
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.category = category;
        this.accountId = accountId;
        this.price = price;
        this.discount = discount;
        this.shipmentPlans = shipmentPlans;

    }

    @Override
    public String toString()
    {
        return ("Name: " + this.name + " \n"+
        "Weight: " + this.weight +" \n"+
        "ConditionUsed: " + this.conditionUsed + " \n" +
        "Category: "+ this.category +" \n" +
        "\nprice: " + price +
        "\ndiscount: " + discount + 
        "\naccountId: " + accountId);

    }
}
