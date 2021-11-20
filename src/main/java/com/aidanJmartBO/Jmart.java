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
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
@SpringBootApplication
public class Jmart
{
	
	public static long DELIVERED_LIMIT_MS;
	public static long ON_DELIVERY_LIMIT_MS;
	public static long ON_PROGRESS_LIMIT_MS;
	public static long WAITING_CONF_LIMIT_MS;
	
	public static boolean paymentTimekeeper(Payment payment) {
		 Payment.Record record = payment.history.get(payment.history.size() - 1);
	        long elapsed = System.currentTimeMillis() - record.date.getTime();
	        if (record.status.equals(Invoice.Status.WAITING_CONFIRMATION) && (elapsed > WAITING_CONF_LIMIT_MS)) {
	            record.status = Invoice.Status.FAILED;
	            return true;
	        }else if (record.status.equals(Invoice.Status.DELIVERED) && (elapsed > DELIVERED_LIMIT_MS)) {
	            record.status = Invoice.Status.FINISHED;
	            return true;
	        } else if (record.status.equals(Invoice.Status.ON_PROGRESS) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
	            record.status = Invoice.Status.FAILED;
	            return true;
	        } else if (record.status.equals(Invoice.Status.ON_DELIVERY) && (elapsed > ON_PROGRESS_LIMIT_MS)) {
	            record.status = Invoice.Status.DELIVERED;
	            return true;
	        }  else {
	            return false;
	        	}
	}
	
    class Country
    {
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    
    public static List<Product> filterByCategory(List<Product> list, ProductCategory category)
    {
        List<Product> products = new ArrayList<>();
        for(Product product : list)
        {
            if(product.category.equals(category))
            {
                products.add(product);
            }
        }
        return products;
    }
    public static List<Product> filterByPrice(List<Product> list, double minPrice, double maxPrice)
    {
        List<Product> produk = new ArrayList<>();
        for(int i = 0; i < list.size(); i++)
        {
            if(minPrice <= 0.0)
            {
                if(list.get(i).price <= maxPrice)
                {
                	produk.add(list.get(i));
                }
            }else if(maxPrice <= 0.0)
            {
                if(list.get(i).price >= minPrice)
                {
                	produk.add(list.get(i));
                }
            }else{
                if(list.get(i).price >= minPrice && list.get(i).price <= maxPrice)
                {
                	produk.add(list.get(i));
                }
            }
        }
        return produk;
    }
    public static void main(String[] args)
    {
    	JsonDBEngine.Run(Jmart.class);
        SpringApplication.run(Jmart.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
//        try{       
//            List<Product> list = read("C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\jmart/randomProductList.json");
//            List<Product> filter = filterByPrice(list, 0.0, 20000.0);
//           // filter.forEach(produk -> System.out.println(produk.price));
//            List<Product> filter2 = filterByName(list, "GTX", 1, 5);
//            filter2.forEach(produk -> System.out.println(produk.name));
//            System.out.println("\n");
//            List<Product> filter3 = filterByAccountId(list, 1, 0, 5);
//            filter3.forEach(produk -> System.out.println(produk.name));
//        }catch (Throwable t)
//        {
//            t.printStackTrace();
//        }
    	
//    	  try{
//    		   String filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\jmart\\account.json" ;
//    		   JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
//    		   
//    		   tableAccount.add(new Account("name", "email", "Password"));
//    		   tableAccount.writeJson();
//    		   tableAccount = new JsonTable<>(Account.class, filepath);
//    		   tableAccount.forEach(account -> System.out.println(account.toString()));
//    		  }
//    		  catch (Throwable t)
//    		  {
//    		   t.printStackTrace();
//    		  }
//    	try {
//            String filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\jmart/randomProductList.json";
//            JsonTable<Payment> table = new JsonTable<>(Payment.class, filepath);
//            ObjectPoolThread<Payment> paymentPool = new ObjectPoolThread<Payment>("Thread-PP", Jmart::paymentTimekeeper);
//            
//            paymentPool.start();
//            table.forEach(payment -> paymentPool.add(payment));
//            
//            while(paymentPool.size() != 0);
//            paymentPool.exit();
//            while(paymentPool.isAlive());
//            System.out.println("Thread exited successfully");
//            Gson gson = new Gson();
//            table.forEach(payment -> {
//                String history = gson.toJson(payment.history);
//                System.out.println(history);
//            });
//            
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }
    	

    }
    public static List<Product> read(String filepath) throws FileNotFoundException 
    {
        List<Product> produk = new ArrayList<>();
        try
        {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader(filepath));
            reader.beginArray();
            while(reader.hasNext())
            {
            	produk.add(gson.fromJson(reader, Product.class));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return produk;
    }
    
    private static List<Product> paginate(List<Product> list, int page, int pageSize, Predicate<Product> pred) {
        return list.stream().filter(i -> pred.predicate(i)).skip(page * pageSize).limit(pageSize).collect(Collectors.toList());
    }

    public static List<Product> filterByName(List<Product> list, String search, int page, int pageSize) {
        Predicate<Product> predicate = i -> (i.name.toLowerCase().contains(search.toLowerCase()));
        return paginate(list, page, pageSize, predicate);
    }

    public static List<Product> filterByAccountId(List<Product> list, int accountId, int page, int pageSize) {
        Predicate<Product> predicate = i -> (i.accountId == accountId);
        return paginate(list, page, pageSize, predicate);
    }
         
        
}
