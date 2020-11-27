package com.spring;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.config.YAMLConfig;
import com.springdata.LoginEntity;
import com.springdata.LoginRepository;

@Service
//@Scope("request")
public class ProfileBean {
	// Spring Data DI	
	
	@Autowired // spring framework
	public LoginRepository ur;
	// concrete dependancy injection 
	// is done by spring framework 
	

	@Autowired
	YAMLConfig yaml;
	

	@Value("${blocked.user}")
	String blockedUser;
	
	public LoginEntity authenticate(String userid,String password) {
		
		System.out.println("Configuration - yaml file:"+yaml.getCompanyLogo());
		System.out.println("Configuration - properties file:"+blockedUser);
		List<LoginEntity> records=ur.findByUidAndPwd(userid, password);
		if(records==null || records.size()==0)
		{
			System.out.println("userid and password did not match in table");
			return null;
		}
		else 
		{
			System.out.println("userid and password did match in table");
			return records.get(0);
		}
	}
	public void register(String userid, String pwd) {
		LoginEntity ue=new LoginEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
	}
	public void update(String userid, String pwd) {
		ur.update(userid, pwd);
	}
	public void delete(String userid) {
		ur.delete(userid);
	}
}
