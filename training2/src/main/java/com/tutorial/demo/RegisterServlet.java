package com.tutorial.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
@WebServlet("/register")  
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login get method");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			// ron
			// ron123
			String uid=req.getParameter("userid");
			String pwd=req.getParameter("pass");
			// uid=ron
			// pwd=ron123
			Connection conn=DatabaseConnection.getDBConnection();
			int regCount=UsersTable.registerUser(uid, pwd, conn);
			if(regCount < 1)
				res.getWriter().write("registration failed");
			else
				res.getWriter().write("registered successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
}
