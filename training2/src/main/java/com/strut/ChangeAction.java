package com.strut;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.config.YAMLConfig;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.ChangeBean;
import com.spring.ProfileBean;
import com.springdata.LoginEntity;

 public class ChangeAction extends ActionSupport {
   
	public String userid;
	public String fname;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	 
	@Autowired
	ChangeBean cb;
	
	public String firstNameUpdate() {
		 boolean res=cb.changeFname(userid, fname);
		 if(res==true)
			 return "success";
		 else
			 return "failure";
	 }
}