package com.aidanJmartBO.controller;

import com.aidanJmartBO.Account;
import com.aidanJmartBO.Store;
import com.aidanJmartBO.dbjson.JsonAutowired;
import com.aidanJmartBO.dbjson.JsonTable;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
	@JsonAutowired(filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\src\\main\\java\\com\\account.json", value = Account.class)
	public static JsonTable<Account> accountTable;
	public static final String REGEX_EMAIL = "([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)";
	public static final String REGEX_PASSWORD = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?!.* ).{8,}";
	public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    
    @Override
    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    
    @PostMapping("/login")
	Account login
	(
		@RequestParam String email,
		@RequestParam String password
	)
	{
		for (Account acc : accountTable) {
			 if(acc.email.equals(email) && acc.password.equals(password)) {
				return acc;
			}
		try {
            MessageDigest md;
            md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            for(Account account : accountTable){
                if(account.email.equals(email) && account.password.equals(password)){
                    return account;
                }
            }
		} catch (NoSuchAlgorithmException e) {
        	throw new RuntimeException(e);            }  
		}
		return null;
	}
    
    
	@PostMapping("/register")
	Account register
	(
		@RequestParam String name,
		@RequestParam String email,
		@RequestParam String password
	)
	{
		if((REGEX_PATTERN_EMAIL.matcher(email).find()) && (REGEX_PATTERN_PASSWORD.matcher(password).find()) && !name.isBlank()){
            for(Account account : accountTable){
                if(account.email.equals(email)){
                    return null;
                }
            }
            try {
                MessageDigest md;
                md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(password.getBytes());
                BigInteger no = new BigInteger(1, messageDigest);
                String hashtext = no.toString(16);
                while (hashtext.length() < 32) {
                    hashtext = "0" + hashtext;
                }
                return new Account(name, email, hashtext, 0);
            } catch (NoSuchAlgorithmException e) {
            	throw new RuntimeException(e);            }  
        }
        return null;
    }
	
	@PostMapping("/{id}/registerStore")
    Store registerStore(int id, String name, String address, String phoneNumber){
        if(accountTable.contains(accountTable.get(id)) && accountTable.get(id).store == null){
            Store newStore = new Store(name, address, phoneNumber, 0);
            accountTable.get(id).store = newStore;
            
            return newStore;
        }
        else{
            return null;
        }
    }
	
	@PostMapping("/{id}/topUp")
    boolean topUp(int id, double balance){
        if(accountTable.contains(accountTable.get(id))){
            accountTable.get(id).balance += balance;
            
            return true;
        }
        else{
            return false;
        }
    }

}