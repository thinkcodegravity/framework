package com.tutorial.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.spring.ProfileBean;
import com.springdata.LoginEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Spring_ModelLayerTest {
	
	// dependancy injection
	public ProfileBean profile; // scanned in test spring config class
	@Autowired
	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	@Test
	public void test1Authenticate() throws Exception {
		LoginEntity res= profile.authenticate("john", "john123");
		assertNotEquals(null, res);
		//assertNotNull(res);
	}
	@Test
	public void test1AuthenticateInvalid() throws Exception {
		LoginEntity res= profile.authenticate("john", "sdfdsf");
		//assertEquals(null, res);
		assertNull(res);
	}
	@Test
	public void test2Register() throws Exception {
		int res=profile.register("mike", "mike123");
		assertEquals(1, res);
	}
	@Test
	public void test3Update() throws Exception {
		int res=profile.update("mike", "mike345");
		assertEquals(1, res);
	}
	@Test
	public void test4Delete() throws Exception {
		int res= profile.delete("mike");
		assertEquals(1, res);
	}
	@Test
	public void test4DeleteinvalidUser() throws Exception {
		int res= profile.delete("abcdef");
		assertEquals(0, res);
	}
	
	@Test
	public void test5updateFNameValid() throws Exception {
		int res= profile.updateFirstName("john","johnjohn"); 
		assertEquals(1, res);
	}
	@Test
	public void test5updateFNameInValid() throws Exception {
		int res= profile.updateFirstName("asdasd","johnjohn"); 
		assertEquals(0, res);
	}
	@Test
	public void test5updateFNameEmptyUserid() throws Exception {
		int res= profile.updateFirstName("","johnjohn"); 
		assertEquals(0, res);
	}
	
}
