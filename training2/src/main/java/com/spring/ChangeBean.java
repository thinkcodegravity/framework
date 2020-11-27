package com.spring;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.config.YAMLConfig;
import com.springdata.LoginEntity;
import com.springdata.LoginRepository;

@Service
//@Scope("session")
public class ChangeBean {
	// Spring Data DI	
	@Autowired
	public LoginRepository ur;
	
	public boolean changeFname(String userid,String fname) {
		int resUpdated=ur.updateFname(userid, fname);
		if(resUpdated > 0)
			return true;
		else
			return false;
	}
	
}
