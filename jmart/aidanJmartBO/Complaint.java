package aidanJmartBO;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public String desc;
    public String date = "16 Mei 2001";
    
    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
    }

    @Override
    public boolean read(String content){
        return false;
    }
}
