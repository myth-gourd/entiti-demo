package com.github.myth.gourd.entiti.demo.test.pojo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.myth.gourd.entiti.demo.pojo.User;

import myth.gourd.entiti.errors.exception.NotEmptyException;
import myth.gourd.entiti.errors.exception.StringOutOfSizeException;
import myth.gourd.entiti.errors.exception.ValidateErrorException;

public class ValidateTest {

	@Test(expected = NotEmptyException.class)
	public void testValidateNotEmpty1() throws ValidateErrorException{
		User user = new User();
		user.validate();
		assertFalse("ValidateNotEmpty false",true);
	}
	
	@Test(expected = StringOutOfSizeException.class)
	public void testValidateNotEmpty2() throws ValidateErrorException{
		User user = new User();
		user.setUsername("username123456789");
		user.setRealname("realname");
		user.validate();
		assertFalse("ValidateNotEmpty false",true);
	}
	
	@Test
	public void testValidateNotEmpty3() throws ValidateErrorException{
		User user = new User();
		user.setUsername("username");
		user.setRealname("realname");
		user.validate();
		assertTrue("ValidateNotEmpty success",true);
	}
}