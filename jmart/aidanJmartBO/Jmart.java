package aidanJmartBO;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Jmart
{
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
        try{       
            List<Product> list = read("C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\jmart/randomProductList.json");
            List<Product> filter = filterByPrice(list, 0.0, 20000.0);
            filter.forEach(produk -> System.out.println(produk.price));
        }catch (Throwable t)
        {
            t.printStackTrace();
        }

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
         
        
}
