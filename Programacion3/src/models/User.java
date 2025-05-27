package models;

import java.util.Date;

public class User {
	
	//users.add(new User(empId,firstName,email,role,phone,null,null)); 

	public int id;
	public String name;
	public String email;
	public String role;
	public String phone;
	public Date dated_create;
	public Date dated_update;

	public User(int id, String name, String email, String role, String phone, Date create, Date update) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.dated_create = create;
		this.dated_update = update;
		// TODO Auto-generated constructor stub
	}
	
    // Getters y setters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getPhone() { return phone; }
    
    public void setName(String firstName) { this.name = firstName; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", phone=" + phone + "}";
    }

}
