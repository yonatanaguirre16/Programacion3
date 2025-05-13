package models;

import java.io.FileNotFoundException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
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
	            Object obj = jsonParser.parse(reader);
	  
	            JSONArray productList = (JSONArray) obj;
	              
	            return productList;
	           
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	        }catch (IOException e){
	            e.printStackTrace();
	        }catch (ParseException e){
	            e.printStackTrace();
	        }
       
	        return null;
			
		}
		
		public void remove(Long id) {
		    JSONArray productList = get();
		    String url = AuthModel.class.getResource("/files/products.json").getPath();

		    @SuppressWarnings("unchecked")
			Iterator<Object> iterator = productList.iterator();
		    while (iterator.hasNext()) {
		        JSONObject product = (JSONObject) iterator.next();
		        Long productId = (Long) product.get("id");
		        if (productId != null && productId.equals(id)) {
		            iterator.remove();  
		            break;
		        }
		    }

		    try (FileWriter file = new FileWriter(url)) {
		        file.write(productList.toJSONString());
		        file.flush();
		        System.out.println("Producto eliminado correctamente.");
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
		
		public boolean addProduct(String name, String category, String brand, String desc ){
			
			JSONArray productList = get();
			JSONObject jsonObject = new JSONObject();
			
			String url = AuthModel.class.getResource("/files/products.json").getPath();
			
		    long newId = 1;
		    for (Object obj : productList) {
		        JSONObject p = (JSONObject) obj;
		        Long existingId = (Long) p.get("id");
		        if (existingId != null && existingId >= newId) {
		            newId = existingId + 1;
		        }
		    }
			
			jsonObject.put("id", newId++);
			jsonObject.put("title", name);
			jsonObject.put("description", desc);
			jsonObject.put("category", category);
			jsonObject.put("brand", brand);


			
			productList.add(jsonObject);
			
			try (FileWriter file = new FileWriter(url)) {
	            file.write(productList.toString()); 
	            file.flush();
	            file.close();
	            System.out.println("El producto se agregó correctamente.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			return false;
		}


}
