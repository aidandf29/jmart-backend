package aidanJmartBO;
import java.util.Date;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    
    public String desc;
    public Date date;
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read(String content){
        return false;
    }
}
