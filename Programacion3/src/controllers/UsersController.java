package controllers;

import java.util.ArrayList;

import models.User;
import models.UsersModel;
import views.UsersView;

public class UsersController {
	
	public UsersView view;

	public UsersController() {
		
		view = new UsersView();
	}
	
	public void usuarios() {
		
		UsersModel um = new UsersModel();
		ArrayList<User> listaUsuarios = um.get(); 
		
		view.usuarios(listaUsuarios); 
		
	}

	
	public void add() {
		
		view.addUsers();
		
	}
	
	public void update(User usertoUpdate) {
		view.updateUsers(usertoUpdate);
	}
}
