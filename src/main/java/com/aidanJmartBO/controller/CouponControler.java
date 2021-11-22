package com.aidanJmartBO.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.Algorithm;
import com.aidanJmartBO.Coupon;
import com.aidanJmartBO.Predicate;
import com.aidanJmartBO.dbjson.JsonAutowired;
import com.aidanJmartBO.dbjson.JsonTable;

@RestController
@RequestMapping("/coupon")
public class CouponControler implements BasicGetController<Coupon> {

	@JsonAutowired(filepath = "C:\\Users\\aidan\\Documents\\nguliah\\smt 5\\OOP\\Project\\src\\main\\java\\com\\randomProductList.json", value = Coupon.class)
    public static JsonTable<Coupon> couponTable;
    
    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id, 
            @PathVariable double price, 
            @PathVariable double discount
    ){
         for(Coupon kupon : couponTable){
             if(kupon.id == id){
                 return kupon.canApply(price, discount);
             }
         }
         return false;
    };
    
    @GetMapping("/getAvailable")
    @ResponseBody
    List<Coupon> getAvailable
    (
            @PathVariable int page, 
            @PathVariable int pageSize
    ){
        Predicate<Coupon> pred = kupon -> !kupon.isUsed();
        return Algorithm.paginate(couponTable, page, pageSize, pred);
    }

    @Override
    public JsonTable<Coupon> getJsonTable() {
        return couponTable;
    }
    
    @GetMapping("/{id}/isUsed")
    boolean isUsed(@PathVariable int id){
        Coupon kupon = Algorithm.<Coupon>find(couponTable, obj -> obj.id == id);
        return kupon.isUsed();
    }

}
