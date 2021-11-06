package aidanJmartBO;

import java.util.Comparator;
import java.util.*;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable implements Comparable <Serializable>
{
    final public int id;
    
    protected Serializable()
    {
    	Class getClas = getClass();
        if(mapCounter.get(getClas) == null)
        {
            mapCounter.put(getClas,0);
        }else 
        {
            mapCounter.put(getClas, mapCounter.get(getClas) + 1);
        }
        this.id =mapCounter.get(getClas);
    }
    
    public boolean equals(Object object)
    {
        if(object instanceof Serializable) {
            Serializable serializable = (Serializable) object;
            if(serializable.id == this.id) {
                return true;
            }
            else {
                return false;
            }
            
        }
        else {
            return false;
        }
    }
    
    public boolean equals(Serializable serializable)
    {
        if (serializable.id == this.id) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public int compareTo(Serializable other)
    {
    	return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }
    
    public static <T extends Serializable> Integer getClosingId (Class<T>clazz)
    {
    	return mapCounter.get(clazz.getClass());
    }
    
    public static <T extends Serializable> Integer setClosingId (Class<T>clazz, int id)
    {
    	return mapCounter.replace(clazz, id);
    }
    
    private static HashMap <Class<?>, Integer> mapCounter = new HashMap<>();
    
}


