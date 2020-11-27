package com.spring;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.config.YAMLConfig;
import com.springdata.LoginEntity;
import com.springdata.LoginRepository;

@Service
@Scope("session")
public class CartBean {
	public ArrayList<String> cart=new ArrayList<String> ();
	public ArrayList<String>  add2Cart(String proName) {
		cart.add(proName);
		return cart;
	}
}
