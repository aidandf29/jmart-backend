package aidanJmartBO;


/**
 * Write a description of class Shipment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Shipment implements FileParser
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
        public byte bit;

        private Duration(byte bit)
        {
            this.bit = bit;
        }
        public Duration(Duration... args)
        {
            byte bits = 0;
            for(Duration arg : args){
                bits |= arg.bit;
            }
            this.bit = bits;
        }
        
    }
    
    public class MultiDuration{
        public byte bit;
        public MultiDuration(Duration... args){
            
            byte bits = 0;
            for(Duration arg : args){
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

    @Override
    public boolean read(String content) {
        return false;
    }
}
