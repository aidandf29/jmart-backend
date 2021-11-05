package aidanJmartBO;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable <Recognizable>
{
    final public int id;
    
    protected Recognizable()
    {
        this.id = 29;
    }
    
    public boolean equals(Object object)
    {
        if(object instanceof Recognizable) {
            Recognizable recognizable = (Recognizable) object;
            if(recognizable.id == this.id) {
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
    
    public boolean equals(Recognizable recognizable)
    {
        if (recognizable.id == this.id) {
            return true;
        }
        else {
            return false;
        }
    }
    
    @Override
    public int compareTo(Recognizable other)
    {
    	return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }
    
    public static <T extends Recognizable> int getClosingId (Class<T>clazz)
    {
    	return 0;
    }
    
    public static <T extends Recognizable> int setClosingId (Class<T>clazz, int id)
    {
    	return 0;
    }
}


