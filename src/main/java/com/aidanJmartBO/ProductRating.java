package com.aidanJmartBO;


/**
 * ProductRating class is code for ProductRating
@author Muh. Aidan Daffa
*/

public class ProductRating
{
    private long total;
    private long count;
    
    public ProductRating()
    {
        this.total = 0;
        this.count = 0;
    }
    
    public void insert(int rating)
    {
        this.total += rating;
        count++;
    }
    
    public double getAverage()
    {
        if (count != 0){
            return this.total / (double)this.count;
        }
        else{
            return 0.0;
        }
    }
    
    public long getCount()
    {
        return count;
    }
    
    public long getTotal()
    {
        return total;
    }
    
    
}
