package aidanJmartBO;
import java.util.regex.*;

/**
 * Write a description of class Account here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;
    public final static String REGEX_EMAIL = "(^[a-zA-Z0-9&_*~]+(?:\\.[a-zA-Z0-9&_*~]+)*@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)"; 
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])[a-zA-Z\\d]{8,}$";
    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean read(String content)
    {
        return false;
    }
    
    @Override
    public String toString()
    {
        return "Name : " + this.name + "\nEmail : " + this.email + "\nPassword : " + this.password;
    }
    
     public boolean validate() {
        Pattern emailPattern = Pattern.compile(REGEX_EMAIL);
        Pattern passwordPattern = Pattern.compile(REGEX_PASSWORD);
        Matcher emailMatcher = emailPattern.matcher(this.email);
        Matcher passwordMatcher = passwordPattern.matcher(this.password);
        if(emailMatcher.find() && passwordMatcher.find()) {
            return true;
        }
        else {
            return false;
        }
    }
    
}
