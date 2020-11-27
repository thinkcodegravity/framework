package com.strut;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.config.YAMLConfig;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.ProfileBean;
import com.springdata.LoginEntity;

 public class ProfileAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    Logger log=Logger.getLogger("ProfileAction"); 
    // STRUT BEAN - UI FORM DATA - PULL
    public String userid; 
	public String pass; 
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
    // UI FORM DATA
	
	// STRUT MODEL
	@Autowired
	ProfileBean profileBean;
	public String authenticate() {
		System.out.println("in action program authenticate method");
		try {
			fruits.add("mango");
			fruits.add("grapes");
			fruits.add("apple");
			
			LoginEntity records=profileBean.authenticate(userid, pass);
			if(records==null ) {
				return "failure";
			}else {
				firstName=records.getFname();
				lastName=records.getLname();
				return "success";
			}
		}catch(Exception e) {
			return "failure";
		}	
	}
	 
	// response webpage form bean
	public String firstName;
	public String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public ArrayList<String> fruits=new ArrayList<String> ();
	public ArrayList<String> getFruits() {
		return fruits;
	}
	public void setFruits(ArrayList<String> fruits) {
		this.fruits = fruits;
	}
}