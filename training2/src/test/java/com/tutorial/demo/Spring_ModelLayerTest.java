package com.tutorial.demo;

import static org.junit.Assert.assertEquals;
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
	
	public ProfileBean profile; // scanned in test spring config class
	@Autowired
	public void setProfile(ProfileBean profile) {
		this.profile = profile;
	}

	@Test
	public void test1Authenticate() throws Exception {
		LoginEntity res= profile.authenticate("john", "john123");
		assertNotEquals(null, res);
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
}
