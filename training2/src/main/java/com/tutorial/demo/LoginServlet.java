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

@WebServlet("/loginprocess") // annotation.... configuration technique
// in your laptop/eclipse tool = http://localhost/loginprocess
// in your aws website = http://ec2.12_12.1.2.aws.com/loginprocess
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("login get method");
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		try {
			// access customer input
			String uid=req.getParameter("userid");
			String pwd=req.getParameter("pass");
			System.out.println("customer entered userid:"+uid);
			System.out.println("customer entered pass:"+pwd);
			System.out.println(req.getRemoteAddr() +"tried login attempt");
			boolean loginStatus=false;
			
			Connection conn=null;
			try {
				// get DB connection
				conn=DatabaseConnection.getDBConnection();
				// disable auto save
				conn.setAutoCommit(false);
				
					// write DB code here
					loginStatus=UsersTable.validateLogin(uid, pwd, conn);
				
				// save all temp DB changes
				conn.commit();
			}catch(Exception e) {
				// revert all temp DB changes
				conn.rollback();
				e.printStackTrace();
			}finally {
				// close DB connection
				conn.close();
			}
			
			
			// process information
			if( loginStatus == true)
			{	// send response back
				//res.sendRedirect("success.jsp");// jsp = java + html code
				req.getRequestDispatcher("success.jsp").forward(req, res);
			}else
				req.getRequestDispatcher("error.jsp").forward(req, res);
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/*
	// 12.12.12.12
	String ip = req.getRemoteAddr();
	if (ip == "12.12.12.12") {
		res.getWriter().print("security threat detected... you are blocked");
		return;
	}

	String acctTo = req.getParameter("destinationAcct");
	String transferAmmount = req.getParameter("amount");

	HttpSession customerSession = req.getSession();
	customerSession.invalidate();

	boolean isloggedin = (boolean) customerSession.getAttribute("isloggedIn");
	if (isloggedin == true)
		System.out.println("transfer money");
	else
		res.sendRedirect("login.html"); // send session id - 123
*/
}
