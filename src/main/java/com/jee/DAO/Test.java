package com.jee.DAO;

import java.util.Date;

import com.java.beans.User;


public class Test {
	
	public static void main(String[] args) {
		
		DataBase db=new DataBase(new MySQLDataSource("servlet"));
		
		System.out.println(db.insertElement(new User("salma","salma@gmail","123")));
		
		//System.out.println(db.insertElement(new Commande(3,"14-02-2022",2,new Client(2,"Aoulad","Omar"), 
			//	new Produit(34,"d04",3,43))));
		
		
	}
	
	
}

