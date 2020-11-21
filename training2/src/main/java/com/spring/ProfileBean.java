package com.spring;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springdata.LoginEntity;
import com.springdata.LoginRepository;

@Service
//@Scope("session")
public class ProfileBean {
	// Spring Data DI	
	@Autowired
	public LoginRepository ur;
	
	public LoginEntity authenticate(String userid,String password) {
		System.out.println("checking login information in db for "+userid);
		if(userid == null || password ==null)
			return null;
		List<LoginEntity> records=ur.findByUidAndPwd(userid, password);
		if(records==null || records.size()==0)
			return null;
		else 
			return records.get(0);
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
