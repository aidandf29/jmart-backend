package com.aidanJmartBO;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;


public class Algorithm {

	private Algorithm()
	{
		
	}
	
	 public static <T> List<T> collect(T[] array, T value) 
	 {
	        List<T> list = new ArrayList<T>();
	        for(T t : array)
	        {
	            if(t.equals(value))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }
	    public static <T> List<T> collect(Iterable<T> iterable, T value)
	    {
	        List<T> list = new ArrayList<T>();
	        for(T t : iterable)
	        {
	            if(t.equals(value))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }
	    public static <T> List<T> collect(Iterator<T> iterator, T value) 
	    {
	        List<T> list = new ArrayList<T>();
	        while(iterator.hasNext())
	        {
	            T t = iterator.next();
	            if(t.equals(value))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }
	    public static <T> List<T> collect(T[] array, Predicate<T> pred) 
	    {
	        List<T> list = new ArrayList<T>();
	        for(T t : array)
	        {
	            if(pred.predicate(t))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }
	    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) 
	    {
	        List<T> list = new ArrayList<T>();
	        for(T t : iterable)
	        {
	            if(pred.predicate(t))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }
	    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) 
	    {
	        List<T> list = new ArrayList<T>();
	        while(iterator.hasNext())
	        {
	            T t = iterator.next();
	            if(pred.predicate(t))
	            {
	                list.add(t);
	            }
	        }
	        return list;
	    }

	    //count
	    public static <T> int count(T[] array, T value) 
	    {
	        int counter = 0;
	        for (T arrayValue : array) 
	        {
	            if (arrayValue.equals(value)) 
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }
	    public static <T> int count(Iterable<T> iterable, T value) 
	    {
	        int counter = 0;
	        for (T t : iterable) 
	        {
	            if (t.equals(value)) 
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }
	    public static <T> int count(Iterator<T> iterator, T value) 
	    {
	        int counter = 0;
	        while (iterator.hasNext()) 
	        {
	            if (iterator.next().equals(value))
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }
	    public static <T> int count(T[] array, Predicate<T> pred) 
	    {
	        int counter = 0;
	        for (T arrayValue : array) 
	        {
	            if (pred.predicate(arrayValue)) 
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }
	    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) 
	    {
	        int counter = 0;
	        for (T t : iterable) 
	        {
	            if (pred.predicate(t)) 
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }
	    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) 
	    {
	        int counter = 0;
	        while (iterator.hasNext()) 
	        {
	            if (pred.predicate(iterator.next())) 
	            {
	                counter++;
	            }
	        }
	        return counter;
	    }

	    //exists
	    public static <T> boolean exists(T[] array, T value) 
	    {
	        for (T arrayValue : array) 
	        {
	            if (arrayValue.equals(value)) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static <T> boolean exists(Iterable<T> iterable, T value) 
	    {
	        for (T t : iterable) 
	        {
	            if (t.equals(value)) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static <T> boolean exists(Iterator<T> iterator, T value) 
	    {
	        while (iterator.hasNext()) 
	        {
	            if (iterator.next().equals(value)) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static <T> boolean exists(T[] array, Predicate<T> pred) 
	    {
	        for (T arrayValue : array) 
	        {
	            if (pred.predicate(arrayValue)) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) 
	    {
	        for (T t : iterable) 
	        {
	            if (pred.predicate(t)) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) 
	    {
	        while (iterator.hasNext()) 
	        {
	            if (pred.predicate(iterator.next())) 
	            {
	                return true;
	            }
	        }
	        return false;
	    }

	   	    public static <T> T find(T[] array, T value) 
	   	    {
	        for (T arrayValue : array) 
	        {
	            if (arrayValue.equals(value)) 
	            {
	                return arrayValue;
	            }
	        }
	        return null;
	    }
	   	    
	    public static <T> T find(Iterable<T> iterable, T value) 
	    {
	        for (T t : iterable) 
	        {
	            if (t.equals(value)) 
	            {
	                return t;
	            }
	        }
	        return null;
	    }
	    
	    public static <T> T find(Iterator<T> iterator, T value) 
	    {
	        while (iterator.hasNext()) 
	        {
	            if (iterator.next().equals(value)) 
	            {
	                return value;
	            }
	        }
	        return null;
	    }
	    
	    public static <T> T find(T[] array, Predicate<T> pred) 
	    {
	        for (T arrayValue : array) 
	        {
	            if (pred.predicate(arrayValue)) 
	            {
	                return arrayValue;
	            }
	        }
	        return null;
	    }
	    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) 
	    {
	        for (T t : iterable)
	        {
	            if (pred.predicate(t))
	            {
	                return t;
	            }
	        }
	        return null;
	    }
	    
	    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) 
	    {
	        while (iterator.hasNext()) 
	        {
	            T value = iterator.next();
	            if (pred.predicate(value)) 
	            {
	                return value;
	            }
	        }
	        return null;
	    }

	    
	    public static <T extends Comparable<? super T>> T max(T first, T second) 
	    {
	        if ((first.compareTo(second)) > 0) 
	        {
	            return first;
	        } else 
	        {
	            return second;
	        }
	    }
	    
	    public static <T extends Comparable<? super T>> T max(T[] array) 
	    {
	        T maximum = array[0];
	        for (T t : array) 
	        {
	            if (t.compareTo(maximum) > 0) 
	            {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }
	    
	    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable) 
	    {
	        T maximum = iterable.iterator().next();
	        for (T t : iterable) 
	        {
	            if (t.compareTo(maximum) > 0) 
	            {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }
	    
	    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator) 
	    {
	        T maximum = iterator.next();
	        while (iterator.hasNext()) 
	        {
	            T t = iterator.next();
	            if (t.compareTo(maximum) > 0) 
	            {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }

	    public static <T extends Comparable<? super T>> T max(T first, T second, Comparator<? super T> comparator) 
	    {
	        if (comparator.compare(first, second) > 0) 
	        {
	            return first;
	        } else
	        {
	            return second;
	        }
	    }
	    public static <T extends Comparable<? super T>> T max(T[] array, Comparator<? super T> comparator)
	    {
	        T maximum = array[0];
	        for (T t : array) 
	        {
	            if (comparator.compare(t, maximum) > 0) {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }
	    
	    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
{
	        T maximum = iterable.iterator().next();
	        for (T t : iterable) 
	        {
	            if (comparator.compare(t, maximum) > 0) 
	            {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }
	    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator) 
	    {
	        T maximum = iterator.next();
	        while (iterator.hasNext()) 
	        {
	            T t = iterator.next();
	            if (comparator.compare(t, maximum) > 0)
	            {
	                maximum = t;
	            }
	        }
	        return maximum;
	    }

	    //min Comparable
	    public static <T extends Comparable<? super T>> T min(T first, T second)
	    {
	        if ((first.compareTo(second)) > 0) 
	        {
	            return second;
	        } else 
	        {
	            return first;
	        }
	    }
	    public static <T extends Comparable<? super T>> T min(T[] array) 
	    {
	        T minimum = array[0];
	        for (T t : array) 
	        {
	            if (t.compareTo(minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }
	    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
	    {
	        T minimum = iterable.iterator().next();
	        for (T t : iterable) 
	        {
	            if (t.compareTo(minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }
	    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator) 
	    {
	        T minimum = iterator.next();
	        while (iterator.hasNext())
	        {
	            T t = iterator.next();
	            if (t.compareTo(minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }

	    //min Comparator
	    public static <T extends Comparable<? super T>> T min(T first, T second, Comparator<? super T> comparator)
	    {
	        if (comparator.compare(first, second) < 0) 
	        {
	            return first;
	        } else 
	        {
	            return second;
	        }
	    }
	    public static <T extends Comparable<? super T>> T min(T[] array, Comparator<? super T> comparator)
	    {
	        T minimum = array[0];
	        for (T t : array) 
	        {
	            if (comparator.compare(t, minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }
	    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
	    {
	        T minimum = iterable.iterator().next();
	        for (T t : iterable) 
	        {
	            if (comparator.compare(t, minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }
	    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator)
	    {
	        T minimum = iterator.next();
	        while (iterator.hasNext())
	        {
	            T t = iterator.next();
	            if (comparator.compare(t, minimum) < 0) 
	            {
	                minimum = t;
	            }
	        }
	        return minimum;
	    }
	    
	    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred){
	        //Convert array to List
	        List<T> newList = new ArrayList<>();
	        for(T t : array){
	            newList.add(t);
	        }
	        try{
	            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
	            int endIndex = (page * pageSize) + pageSize;
	            if(endIndex > filteredList.size()){
	                endIndex = filteredList.size();
	            }
	            return filteredList.subList((page * pageSize), endIndex);
	        }catch (Exception e){
	            return newList.subList(0 ,0);
	        }
	    }
	    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred){
	        //Convert array to List
	        List<T> newList = new ArrayList<>();
	        for(T t : iterable){
	            newList.add(t);
	        }
	        try{
	            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
	            int endIndex = (page * pageSize) + pageSize;
	            if(endIndex > filteredList.size()){
	                endIndex = filteredList.size();
	            }
	            return filteredList.subList((page * pageSize), endIndex);
	        }catch (Exception e){
	            return newList.subList(0 ,0);
	        }
	    }
	    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred){
	        //Convert array to List
	        List<T> newList = new ArrayList<>();
	        while(iterator.hasNext()){
	            newList.add(iterator.next());
	        }
	        try{
	            List<T> filteredList = newList.stream().filter(pred::predicate).collect(Collectors.toList());
	            int endIndex = (page * pageSize) + pageSize;
	            if(endIndex > filteredList.size()){
	                endIndex = filteredList.size();
	            }
	            return filteredList.subList((page * pageSize), endIndex);
	        }catch (Exception e){
	            return newList.subList(0 ,0);
	        }
	    }
	
}
