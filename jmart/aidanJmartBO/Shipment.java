package aidanJmartBO;
import java.util.Date;
import java.text.SimpleDateFormat; 

/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment
{
    public String address;
    public int shipmentCost;
    public Duration duration;
    public String receipt;
    

    public static class Duration
    {
        public static final Duration INSTANT = new Duration ((byte) (1<<0)); //0000 0001
        public static final Duration SAME_DAY = new Duration ((byte) (1<<1)); //0000 0010
        public static final Duration NEXT_DAY = new Duration ((byte) (1<<2)); //0000 0100
        public static final Duration REGULER = new Duration ((byte) (1<<3)); //0000 1000
        public static final Duration KARGO = new Duration ((byte) (1<<4)); //0001 0000
        public final byte bit;
        //public static final Date ESTIMATION_FORMAT;
        SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy"); 
        
        private Duration(byte bit)
        {
            this.bit = bit;
        }
        
        public String getEstimatedArrival(Date reference)
        {
            Date date = new Date();
            if (this.bit == 1 << 0 || this.bit == 1 << 1)
            {
              return ESTIMATION_FORMAT.format(reference);  
            }
            else if (this.bit == 1 << 2 )
            {
                return ESTIMATION_FORMAT.format(reference.getDay() + 1);
            }
            else if (this.bit == 1 << 3 )
            {
                return ESTIMATION_FORMAT.format(reference.getDay() + 2);
            }
            else
            {
                return ESTIMATION_FORMAT.format(reference.getDay() + 5);
            }
            
            
            /*Calendar calendar = Calendar.getInstance();
            cal.setTime(reference);
            if(bit == Duration.NEXT_DAY.bit)
            {
                calendar.add(Calendar.Date,1);
            }
            else if (bit == Duration.REGULER.bit)
            {
                calendar.add(Calendar.Date,2);
            }
            else if(bit == Duration.KARGO.bit)
            {
                calendar.add(Calendar.Date,5);
            }
            if(bit == Duration.INSTANT.bit | bit == Duration.SAME_DAY.bit)
            {
                calendar.add(Calendar.Date,0);
            }*/
        }
    }
    
    public class MultiDuration{
        public byte bit;
        public MultiDuration(Duration... args)
        {
            
            byte bits = 0;
            for (Duration arg : args){
                bits |= arg.bit;
            }
            this.bit = bits;     
        }
        
        public boolean isDuration(Duration reference)
        {
            if((bit & reference.bit) != 0){
                return true;
            }else{
                return false;
            }
        }
    }

    public Shipment(String address, int shipmentCost, Duration duration, String receipt)
    {
        this.address = address;
        this.shipmentCost = shipmentCost;
        this.duration = duration;
        this.receipt = receipt;
    }

}
