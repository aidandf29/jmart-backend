package aidanJmartBO;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    
    public String desc;
    public final Date date;
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formattedDate.format(this.date);
        return "Complaint{Date = " + currentDate + "\n,Desc : " + this.desc +"}";
    }
}
