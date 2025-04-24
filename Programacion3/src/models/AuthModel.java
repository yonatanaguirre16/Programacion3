package models;
import views.AuthView;
public class AuthModel {

	public AuthModel() {
		
	}
	
	public boolean access(String u, String p){
		
		if(u.equals("fake@mail.com") ) {
			if(p.equals("12345")) {
				
				return true; 
				
			}else {
				return false;
				
			}
		}else {
			return false; 
		}
		 
	}
	
	public String nuevoRegistro(String user, String bio) {
		
		return "Registro correcto" + user + "Bio: " + bio;  
	}

}
