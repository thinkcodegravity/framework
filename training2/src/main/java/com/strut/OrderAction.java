package com.strut;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.config.YAMLConfig;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.CartBean;
import com.spring.ChangeBean;
import com.spring.ProfileBean;
import com.springdata.LoginEntity;

 public class OrderAction extends ActionSupport {
   public String proName;
   	 
	public String getProName() {
	return proName;
}

public void setProName(String proName) {
	this.proName = proName;
}

@Autowired
CartBean cb;
	
	public String add2Cart() {
		cart=cb.add2Cart(proName);
		return "success";
	}

public ArrayList<String> cart;

public ArrayList<String> getCart() {
	return cart;
}

public void setCart(ArrayList<String> cart) {
	this.cart = cart;
}


	
}