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
@WebServlet("/change")
public class ChangePasswordServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login get method");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			String uid=req.getParameter("userid");
			String pwd=req.getParameter("pass");
			Connection conn=DatabaseConnection.getDBConnection();
			int upCount=UsersTable.updatePwd(uid, pwd, conn);
			if(upCount < 1)
				res.getWriter().write("password update failed");
			else
				res.getWriter().write("password update successfull");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	 
}
