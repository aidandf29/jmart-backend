package com.aidanJmartBO;
import java.util.regex.*;

/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Store extends Serializable
{
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[a-z](?!.(\\s)).{4,20}$";
    public double balance;
    
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    
    public Store(Account account, String name, String address, String phoneNumber)
    {
        //this.account = account;
        
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public boolean validate()
    {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher MatcherPhone = patternPhone.matcher(this.phoneNumber);
        Matcher MatcherName = patternName.matcher(this.name);
        
        if(MatcherPhone.find() && MatcherName.find()) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    @Override
    public String toString()
    {
        return "Name : " + this.name + "\nAddress : " + this.address + "\nPhoneNumber : " + this.phoneNumber;
    }
    
}
