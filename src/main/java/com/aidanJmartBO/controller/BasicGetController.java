package com.aidanJmartBO.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aidanJmartBO.Algorithm;
import com.aidanJmartBO.Predicate;
import com.aidanJmartBO.dbjson.JsonTable;
import com.aidanJmartBO.dbjson.Serializable;

/**
 * class BasiGetController is the class that route pages and id
@author Muh. Aidan Daffa
*/


@RestController
public interface BasicGetController<T extends Serializable> {
	
    @GetMapping("/page")
    public default List<T> getPage(@RequestParam int page, @RequestParam int pageSize) {
        Predicate<T> pred = element -> true;
        List<T> list = Algorithm.collect(getJsonTable(), pred);
        return Algorithm.<T>paginate(list, page, pageSize, pred);
    }
    
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id){ 
        Predicate<T> pred = element -> element.id == id;
        return Algorithm.find(getJsonTable().iterator(), pred);
    }
    
    public abstract JsonTable<T> getJsonTable();
}