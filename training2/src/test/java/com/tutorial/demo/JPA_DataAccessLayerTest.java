package com.tutorial.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

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
import com.springdata.LoginEntity;
import com.springdata.LoginRepository; 
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPA_DataAccessLayerTest {
	@Autowired
	LoginRepository ur;
	

	@Test
	public void test1CreateRecord() {
		LoginEntity le=new LoginEntity();
		le.setFname("mike");
		le.setLname("m");
		le.setUid("mike");
		le.setPwd("mike123");
		LoginEntity res=ur.save(le);
		assertNotEquals(null , res);
	}
	
	@Test 
	public void test2FindByUidPwd() {
		List<LoginEntity> li=ur.findByUidAndPwd("mike", "mike123");
		assertEquals(1 , li.size());
	}
	
	@Test 
	public void test3SearchByUidPwd() {
		List<LoginEntity> li=ur.verify("mike", "mike123");
		assertEquals(1 , li.size());
	}
	
	@Test 
	public void test4Update() {
		int res=ur.update("mike", "mike456");
		assertEquals(1, res);
	}
	@Test 
	public void test5UpdateFname() {
		int res=ur.updateFname("mike", "mikemike");
		assertEquals(1, res);
	}
	@Test 
	public void test6Delete() {
		int res=ur.delete("mike");
		assertEquals(1, res);
	}	
}
