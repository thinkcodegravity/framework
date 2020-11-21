package com.strut;
import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.spring.ProfileBean;
import com.springdata.LoginEntity;
import com.springdata.LoginRepository;
import com.tutorial.demo.DatabaseConnection;
import com.tutorial.demo.UsersTable;

 public class ProfileAction extends ActionSupport  {
    private static final long serialVersionUID = 1L;
    
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
		try {
			System.out.println("entering struts action model/business method ");
			LoginEntity records=profileBean.authenticate(userid, pass);
			if(records==null )
				return "failure";
			else {
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
}