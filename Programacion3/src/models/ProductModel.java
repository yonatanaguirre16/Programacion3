package models;

import java.io.FileNotFoundException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Reader;



public class ProductModel {
	public ProductModel() {
			
		}
		
		public JSONArray get()
		{
			
			JSONParser jsonParser = new JSONParser();
			String url = AuthModel.class.getResource("/files/products.json").getPath();
	        
	        try (FileReader reader = new FileReader(url))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	  
	            JSONArray productList = (JSONArray) obj;
	            //System.out.println(productList);
	              
	            return productList;
	           
	            
	            //Iterate over  array
	           // productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
	  
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }catch (ParseException e){
	            e.printStackTrace();
	        }
       
	        return null;
			
		}
		
		private static void parseTestData(JSONObject product){
			//  ID, Nombre, Precio, Stock.
			
			String id = (String) product.get("id");
			
		    String title = (String) product.get("title");   
		    //System.out.println("Title: " + title);
		    
		    String precio = (String) product.get("price");
		    
		    String stock = (String) product.get("stock");
		      
		    /*String description = (String) product.get("description");   
		    System.out.println("Description: " + description);
		      
		    String category = (String) product.get("category"); 
		    System.out.println("Category: " + category);*/ 
		    
	    }


}
