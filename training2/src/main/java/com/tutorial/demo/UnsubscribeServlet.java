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
@WebServlet("/unsubscribe") 
public class UnsubscribeServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login get method");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			String uid=req.getParameter("userid");

			Connection conn=DatabaseConnection.getDBConnection();
			int delCount=UsersTable.deleteUser(uid, conn);
			if(delCount < 1)
				res.getWriter().write("deletion failed");
			else
				res.getWriter().write("deleted successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
}
