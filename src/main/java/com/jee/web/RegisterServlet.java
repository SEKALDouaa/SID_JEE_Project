package com.jee.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.beans.User;
import com.jee.DAO.DataBase;
import com.jee.DAO.MySQLDataSource;

public class RegisterServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			System.out.println("Execution d'un service");
			String name=req.getParameter("name");
			String email=req.getParameter("emailu");
			String pwd=req.getParameter("pwdu");
			
			
			System.out.println(name+" "+pwd+" "+ email);
			
			
			DataBase db=new DataBase(new MySQLDataSource("servlet"));
			
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			
			int insert=db.insertElement(new User(name,email,pwd));
			
			if(insert>0) {
				req.setAttribute("success", "You have been registered successfully!");
			}
			else {
				req.setAttribute("failed", "An error has occured");
			}

			dispatcher.forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
