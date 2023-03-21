package Dto;

import java.io.Serializable;

public class Librarian implements Serializable{

private String name;
private String email;
private String password;
private long conno;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public long getConno() {
	return conno;
}
public void setConno(long conno) {
	this.conno = conno;
}


}
