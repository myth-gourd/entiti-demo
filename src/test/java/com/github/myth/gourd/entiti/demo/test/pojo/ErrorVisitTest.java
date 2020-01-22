package com.github.myth.gourd.entiti.demo.test.pojo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.github.myth.gourd.entiti.demo.pojo.User;

import myth.gourd.entiti.errors.ValidateErrorMessageTemplate;
import myth.gourd.entiti.errors.ValidateErrorMessageTemplateOfCN;
import myth.gourd.entiti.errors.exception.ValidateErrorException;
import myth.gourd.entiti.errors.exception.visitor.ValidateErrorExceptionMessageVisitor;

public class ErrorVisitTest {

	@Test
	public void testNotNullVisit() {
		User user = new User();
		try {
			user.setUsername("username");
			user.validate();
		} catch (ValidateErrorException e) 
		{
			ValidateErrorMessageTemplate template = new ValidateErrorMessageTemplateOfCN();
			ValidateErrorExceptionMessageVisitor visitor = new ValidateErrorExceptionMessageVisitor(template);
			e.accept(visitor);
			if (!"真实姓名不能为空".equals(e.getMessage()))
			{
				assertFalse("testNotNullVisit false", true);
			}
		}
		assertTrue("testNotNullVisit", true);
	}
}