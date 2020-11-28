package com.springdata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class LoginEntity {

	@Id
	@Column(name="userid")
	String uid;
	@Override
	public String toString() {
		return "LoginEntity [uid=" + uid + ", pwd=" + pwd + ", fname=" + fname + ", lname=" + lname + "]";
	}
	@Column(name="password")
	String pwd;	
	@Column(name="fname")
	String fname;
	@Column(name="lname")
	String lname;
	
	public LoginEntity(String uid,String pwd,String fname,String lname )
	{
		this.uid=uid;
		this.pwd=pwd;
		this.fname=fname;
		this.lname=lname;
	}
	public LoginEntity(String uid,String pwd )
	{
		this.uid=uid;
		this.pwd=pwd;
	}
	public LoginEntity(String uid)
	{
		this.uid=uid;
	}
	public LoginEntity()
	{
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
}
