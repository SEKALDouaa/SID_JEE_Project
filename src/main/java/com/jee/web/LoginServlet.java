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

public class LoginServlet extends HttpServlet {
	

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pwd = req.getParameter("pwd");

        RequestDispatcher dispatcher=null;
        
        System.out.println(pwd+" "+ email);

        DataBase db = new DataBase(new MySQLDataSource("servlet"));
        User user =(User)db.selectElement(email, pwd, User.class);
        HttpSession session = req.getSession();
        System.out.println(user);
        if (user.getId() != 0) {
            session.setAttribute("user", user);
            dispatcher=req.getRequestDispatcher("home.jsp");
        } else {
            session.setAttribute("error", "Authentication failed. Please try again.");
            dispatcher=req.getRequestDispatcher("index.jsp");
        }
        dispatcher.forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
    
    
}
