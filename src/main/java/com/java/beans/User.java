package com.java.beans;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String pwd;
	
	public User() {
		
	}

	public User( String name, String email, String pwd) {
		this.name = name;
		this.email = email;
		this.pwd = pwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
	
}
