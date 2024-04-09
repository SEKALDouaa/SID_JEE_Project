package com.jee.DAO;

public class MySQLDataSource extends DataSource{
	
	public MySQLDataSource(String username, String password, String database, String host) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://"+host+":3306/"+database,username,password);
	}
	
	public MySQLDataSource(String database, String host) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://"+host+":3306/"+database,"root","1234");
	}
	
	public MySQLDataSource(String database) {
		super("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/"+database,"root","1234");
	}
}
