package models;

import java.util.Date;

public class User {
	
	//users.add(new User(empId,firstName,email,role,phone,null,null)); 

	public int empId;
	public String firstName;
	public String email;
	public String role;
	public String phone;
	public Date dated_create;
	public Date dated_update;

	public User(int empId, String firstName, String email, String role, String phone, Date create, Date update) {
		this.empId = empId;
		this.firstName = firstName;
		this.email = email;
		this.role = role;
		this.phone = phone;
		this.dated_create = create;
		this.dated_update = update;
		// TODO Auto-generated constructor stub
	}
	
    // Getters y setters
    public Integer getId() { return empId; }
    public String getName() { return firstName; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return "User{id=" + empId + ", name=" + firstName + ", email=" + email + ", role=" + role + ", phone=" + phone + "}";
    }

}
