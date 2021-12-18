package com.aidanJmartBO;

import com.aidanJmartBO.dbjson.JsonDBEngine;
import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Jmart as a main class in this project
@author Muh. Aidan Daffa
*/

@SpringBootApplication
public class Jmart
{
	
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
	public static boolean paymentTimekeeper(Payment payment) {
        return false;
    }
	
	//PSVM method
    public static void main(String[] args)
    {
    	JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
        
}
