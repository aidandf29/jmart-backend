package com.aidanJmartBO;
import java.util.Date;

import com.aidanJmartBO.dbjson.Serializable;

import java.text.SimpleDateFormat;

/**
 * Complaint class is code to complaint
@author Muh. Aidan Daffa
*/
public class Complaint extends Serializable
{
    
    public String desc;
    public final Date date;
    
    //constructor
    public Complaint(int id, String desc){
       
        this.desc = desc;
        this.date = new Date();
    }
    
    @Override
    public String toString()
    {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = formattedDate.format(this.date);
        return "Complaint{Date = " + currentDate + "\n,Desc : " + this.desc +"}";
    }
}
