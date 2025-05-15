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
		ArrayList<User> listaUsuarios = um.get();  // Obtener los usuarios desde el modelo
		
		view.usuarios(listaUsuarios);  // Pasarlos a la vista para mostrarlos
		
	}

}
