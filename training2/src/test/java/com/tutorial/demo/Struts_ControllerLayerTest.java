package com.tutorial.demo;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.opensymphony.xwork2.ActionProxy;
import com.strut.ProfileAction; 
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Struts_ControllerLayerTest  extends StrutsSpringJUnit4TestCase<ProfileAction> {
	 

	@Test
	public void test1ValidLogin() throws Exception{
		request.addParameter("userid", "john");
		request.addParameter("pass", "john123");
		ActionProxy proxy=getActionProxy("/loginprocess_strut");
		String result=proxy.execute();
		assertEquals("success", result); // check/compare expected results
		
	}
	@Test
    public void test2InvalidLogin() throws Exception {
        request.addParameter("userid", "a");	// pass param to url
        request.addParameter("pass", "a");
        ActionProxy proxy = getActionProxy("/loginprocess_strut"); // invoke url
        String result = proxy.execute();
        assertEquals("failure", result);        
    }
	@Test
	public void test3InvalidLogin() throws Exception{
		request.addParameter("userid", "");
		request.addParameter("pass", "john123");
		ActionProxy proxy=getActionProxy("/loginprocess_strut");
		String result=proxy.execute();
		assertEquals("failure", result);
	}
	@Test
	public void test4InvalidLogin() throws Exception{
		request.addParameter("userid", "john");
		request.addParameter("pass", "");
		ActionProxy proxy=getActionProxy("/loginprocess_strut");
		String result=proxy.execute();
		assertEquals("failure", result);
	}
	@Test
	public void test5InvalidLogin() throws Exception{
		request.addParameter("userid", "");
		request.addParameter("pass", "");
		ActionProxy proxy=getActionProxy("/loginprocess_strut");
		String result=proxy.execute();
		assertEquals("failure", result);
	}
	
	
}