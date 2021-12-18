package com.aidanJmartBO;
import java.util.regex.*;

import com.aidanJmartBO.dbjson.Serializable;

/**
 * Store class is blueprint code about Store
@author Muh. Aidan Daffa
*/

public class Store extends Serializable
{
	//field
    public String name;
    public String address;
    public String phoneNumber;
    public static final String REGEX_PHONE = "[0-9]{9,12}";
    public static final String REGEX_NAME = "^[a-z](?!.(\\s)).{4,20}$";
    public double balance;
    
    //constructor
    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
    //constructor
    public Store(Account account, String name, String address, String phoneNumber)
    {
        //this.account = account;
        
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    //method to validate
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
