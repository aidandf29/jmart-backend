package aidanJmartBO;


public interface Transactor 
{
    
    public abstract boolean validate();
    public abstract Invoice perform();
}
