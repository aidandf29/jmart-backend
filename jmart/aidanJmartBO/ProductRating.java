package aidanJmartBO;


/**
 * Write a description of class ProductRating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ProductRating
{
    
    private long total;
    private long count;
    public ProductRating(){
        this.total = 0;
    }
    
    public void insert(int rating){
        this.total += rating;
    }
    
    public double getAverage(){
        if (count != 0){
            return this.total / this.count;
        }
        else{
            return 0;
        }
    }
    
    public long getCount(){
        return this.count;
    }
    
    public long getTotal(){
        return this.total;
    }
    
    
}
