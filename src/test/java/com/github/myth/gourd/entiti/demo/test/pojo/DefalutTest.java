package com.github.myth.gourd.entiti.demo.test.pojo;

import org.junit.Test;

import com.github.myth.gourd.entiti.demo.pojo.User;
import com.github.myth.gourd.entiti.demo.pojo.request.AddUserRequest;

import junit.framework.TestCase;

public class DefalutTest extends TestCase {

	@Test
	public void testDefaultAll() {
		AddUserRequest request = CopyTest.getAddUserRequest();
		User user = new User();
		user.copy(request);
		user.defaults();

		if (!user.getUsername().equals(request.getUsername()) || !user.getRealname().equals(request.getRealname())
				|| !user.getDepartmentId().equals(request.getDepartmentId())
				|| !user.getCompany().equals(request.getCompany())) {
			assertFalse("copy error", true);
		}
		if (!"default.jpg".equals(user.getHeadPortrait()) || !"".equals(user.getMobile())
				|| !"".equals(user.getEmail())) {
			assertFalse("default error", true);
		}
		assertTrue("default success", true);
	}
}
