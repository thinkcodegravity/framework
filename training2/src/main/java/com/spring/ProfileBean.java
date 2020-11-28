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
	

	// properties file entry
	@Value("${blocked.user}")
	String blockedUser;
	
	@Value("${company.name}")
	String compName;
	
	public LoginEntity authenticate(String userid,String password) {
		
		System.out.println("\n Entering Spring bean : ProfileBean-authenticate");
		System.out.println("Configuration - yaml file:"+yaml.getCompanyLogo());
		System.out.println("Configuration - properties file:"+blockedUser);
		List<LoginEntity> records=ur.findByUidAndPwd(userid, password);
		if(records==null || records.size()==0)
		{
			System.out.println("\n Exiting Spring bean - userid and password did not match in table");
			return null;
		}
		else 
		{
			System.out.println("\n Exiting Spring bean - userid and password did match in table");
			return records.get(0);
		}
	}
	public int register(String userid, String pwd) {
		System.out.println("Entering Spring bean : ProfileBean-register");
		LoginEntity ue=new LoginEntity();
		ue.setUid(userid);
		ue.setPwd(pwd);
		ur.save(ue);
		return 1;
	}
	public int update(String userid, String pwd) {
		System.out.println("Entering Spring bean : ProfileBean-update");
		return ur.update(userid, pwd);
	}
	public int delete(String userid) {
		System.out.println("Entering Spring bean : ProfileBean-delete");
		return ur.delete(userid);
	}
	public int updateFirstName(String userid,String newFirstName) {
		if(userid.equals(""))
			return 0;
		int res=ur.updateFname(userid, newFirstName);
		return res;
	}
	
	
}
