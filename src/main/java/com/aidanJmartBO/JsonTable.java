package com.aidanJmartBO;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

public class JsonTable<T> extends Vector<T>{
	
	public final String filepath;
	private static final Gson gson = new Gson();
	
	public JsonTable (Class<T>clazz, String filepath) throws IOException{
		this.filepath = filepath;
		try{
            Class<T[]> array = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] hasil = JsonTable.readJson(array, filepath);
            Collections.addAll(this, hasil);
        }
        catch(FileNotFoundException e){
            File file = new File(filepath);
        }
	}
	
	public static <T> T readJson (Class<T> clazz, String filepath) throws FileNotFoundException{
		T readerJson = null;
		  try {
		   final JsonReader reader = new JsonReader(new FileReader(filepath));
		   readerJson = gson.fromJson(reader, clazz);
		  } catch (FileNotFoundException e) {
		   e.printStackTrace();
		  }
		  return readerJson;
	}
	
	public void writeJson() throws IOException{
		writeJson(this, this.filepath);
	}
	
	public static void writeJson (Object object, String filepath)throws IOException {
		try { 
			   final FileWriter writer = new FileWriter(filepath, true);
			   writer.write(gson.toJson(object));
			   writer.close();
			  }
			  catch (IOException e) {
			   e.printStackTrace();
			  }
	}
	
}

