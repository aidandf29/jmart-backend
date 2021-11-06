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


  
        public static final plan INSTANT = new plan ((byte) (1<<0)); //0000 0001
        public static final plan SAME_DAY = new plan ((byte) (1<<1)); //0000 0010
        public static final plan NEXT_DAY = new plan ((byte) (1<<2)); //0000 0100
        public static final plan REGULER = new plan ((byte) (1<<3)); //0000 1000
        public static final plan KARGO = new plan ((byte) (1<<4)); //0001 0000
        //public static final Date ESTIMATION_FORMAT;
        public static final SimpleDateFormat ESTIMATION_FORMAT = new SimpleDateFormat("E MMMM dd yyyy"); 
        public String address;
        public String receipt;
        public int cost;
        public byte plan;
        
        static class plan
        {
            public final byte bit;
            private plan(byte bit)
            {
                this.bit = bit;
            }
        }
        
        public String getEstimatedArrival(Date reference)
        {
        	if((plan & INSTANT.bit) != 0 || (plan & SAME_DAY.bit) != 0){
                return ESTIMATION_FORMAT.format(reference);
            }else if((plan & NEXT_DAY.bit) != 0){
                return ESTIMATION_FORMAT.format(reference.getDay() + 1);
            }else if((plan & REGULER.bit) != 0){
                return ESTIMATION_FORMAT.format(reference.getDay() + 2);
            }else {
                return ESTIMATION_FORMAT.format(reference.getDay() + 5); //KARGO
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
    
//    public class MultiDuration{
//        public byte bit;
//        public MultiDuration(Duration... args)
//        {
//            
//            byte bits = 0;
//            for (Duration arg : args){
//                bits |= arg.bit;
//            }
//            this.bit = bits;     
//        }
        
    public boolean isDuration(plan reference)
    {
        if((plan & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isDuration(byte object, plan reference)
    {
        if((object & reference.bit) != 0){
            return true;
        }else{
            return false;
        }
    }

    public Shipment(String address, int cost, byte plan, String receipt)
    {
        this.address = address;
        this.cost = cost;
        this.plan = plan;
        this.receipt = receipt;
    }

}
