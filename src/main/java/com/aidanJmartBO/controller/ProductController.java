package com.aidanJmartBO.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.Account;
import com.aidanJmartBO.Algorithm;
import com.aidanJmartBO.Product;
import com.aidanJmartBO.ProductCategory;
import com.aidanJmartBO.dbjson.JsonAutowired;
import com.aidanJmartBO.dbjson.JsonTable;

@RestController
@RequestMapping("/product")
public class ProductController implements BasicGetController<Product>{

	@Override
    public JsonTable<Product> getJsonTable() {
        // TODO Auto-generated method stub
        return productTable;
    }
	
	@JsonAutowired(filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\src\\main\\java\\com\\randomProductList.json", value = Product.class)
    public static JsonTable<Product> productTable;
    
    @PostMapping("/create")
    Product create
    (
        @RequestParam int accountId,
        @RequestParam String name,
        @RequestParam int weight,
        @RequestParam boolean conditionUsed,
        @RequestParam double price,
        @RequestParam ProductCategory category,
        @RequestParam byte shipmentPlans,
        @RequestParam double discount
          
    )
    {
        AccountController controlakun = new AccountController();
        JsonTable<Account> accountTable = controlakun.getJsonTable();
        
        for(Account account : accountTable){
            if(account.id == accountId && account.store != null){
                return new Product(accountId, name, weight, conditionUsed, price, discount, category, shipmentPlans);
            }
        }
        return null;
    }
    
    
    
    @GetMapping("/{id}/store")
    @ResponseBody
    List<Product> getProductByStore
            (
                    @RequestParam int id,
                    @RequestParam int pageSize,
                    @RequestParam int page               
            )
            
    {
        return Algorithm.paginate(productTable, page, pageSize,pred->pred.accountId == id);
    }
    
    @GetMapping("/getFiltered")
    List<Product> getProductFiltered(
            @RequestParam int page,
            @RequestParam int pageSize,
            @RequestParam int accountId,
            @RequestParam String search,
            @RequestParam int minPrice,
            @RequestParam int maxPrice,
            @RequestParam ProductCategory category
    ){
    	List<Product> temporaryProduct = null;
        for (Product satuan : productTable) {
            if (satuan.accountId == accountId)
                if (satuan.name.contains(search))
                    if (minPrice <= satuan.price)
                        if (maxPrice >= satuan.price)
                            if (satuan.category == category)
                                temporaryProduct.add(satuan);                  
        }
		return temporaryProduct;
    }

}