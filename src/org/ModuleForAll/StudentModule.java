package org.ModuleForAll;

public class StudentModule {
	int sid;
protected String name,email,contact,username,password;


public StudentModule()
{
	
}





public StudentModule(int sid, String name, String email, String contact, String username, String password) {

	this.sid = sid;
	this.name = name;
	this.email = email;
	this.contact = contact;
	this.username = username;
	this.password = password;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}




	
	

}
