package models;

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

}
