package com.tutorial.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)  {
		try {
			String customProName = req.getParameter("proName");
			HttpSession hs=req.getSession();
			//hs.setAttribute("isLoggedIn", true);
			if(hs.getAttribute("cart")== null)
			{
				ArrayList<String> cartSession=new ArrayList<String> ();
				hs.setAttribute("cart", cartSession);
			}
			//hs.invalidate();
			ArrayList<String> cartSession=(ArrayList<String> )hs.getAttribute("cart");
			cartSession.add(customProName);
			rsp.getWriter().write(cartSession.toString());	
			//rsp.getOutputStream().write(b);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
