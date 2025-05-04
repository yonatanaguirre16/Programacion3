package models;

import java.io.BufferedReader;
import java.io.FileReader;
import views.AuthView;
import views.HomeView;
import controllers.HomeController;

public class AuthModel {

	public AuthModel() {
		
	}
	
	public boolean access(String u, String p) {
	    try {
	        String url = AuthModel.class.getResource("/files/users.txt").getPath();
	        BufferedReader reader = new BufferedReader(new FileReader(url));
	        
	        // bufferedReader lee lineas completas mientras que filereader solo caracter por caracter 

	        String line;
	        while ((line = reader.readLine()) != null) { 
	        	String[] parts = line.split("\\|");
	            if (parts.length >= 8) { // la linea del archivo debe tener mas de 3 partes nombre email y pass
	                String email = parts[6].trim();
	                String password = parts[7].trim();

	                if (u.equals(email) && p.equals(password)) {
	                    reader.close();
	                    
	                    HomeView homeView = new HomeView();
	                    HomeController homeController = new HomeController(homeView);
	                    homeView.setVisible(true);
	                	return true;
	                }
	            }
	        }

	        reader.close();
	        return false;

	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("error");
	        return false;
	    }
	}

	
	
}
