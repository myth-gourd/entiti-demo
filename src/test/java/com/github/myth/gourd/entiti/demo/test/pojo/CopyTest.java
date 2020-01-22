package com.github.myth.gourd.entiti.demo.test.pojo;

import org.junit.Test;

import com.github.myth.gourd.entiti.demo.pojo.User;
import com.github.myth.gourd.entiti.demo.pojo.request.AddUserRequest;
import com.github.myth.gourd.entiti.demo.pojo.request.ModifyContractInfoRequest;

import junit.framework.TestCase;


public class CopyTest extends TestCase
{
	public static AddUserRequest getAddUserRequest()
	{
		AddUserRequest request = new AddUserRequest();
		request.setUsername("username");
		request.setRealname("真实姓名");
		request.setDepartmentId("deptId");
		request.setCompany("公司");
		request.setEmail("abc.google.com");
		request.setMobile("13911001100");
		return request;
	}
	
	public static ModifyContractInfoRequest getModifyContractInfo()
	{
		ModifyContractInfoRequest request = new ModifyContractInfoRequest();
		request.setId("001");
		request.setEmail("abc.sohu.com");
		request.setMobile("13388888888");
		return request;
	}
	
	/**
	 * 测试拷贝所有属性（除CopyIgnore属性外）
	 */
	@Test
	public void testCopyAll() {
		AddUserRequest request = getAddUserRequest();
		User user = new User();
		user.copy(request);
		if (!user.getUsername().equals(request.getUsername()) || !user.getRealname().equals(request.getRealname())
				|| !user.getDepartmentId().equals(request.getDepartmentId())
				|| !user.getCompany().equals(request.getCompany()) || !user.getEmail().equals(request.getEmail())
				|| !user.getMobile().equals(request.getMobile())) {
			assertFalse("copy error", true);
		}
		assertTrue("copy success", true);
	}
	
	/**
	 * 测试拷贝部分属性
	 */
	@Test
	public void testCopyGroup() {
		AddUserRequest request = getAddUserRequest();
		User user = new User();
		user.copy(request);
		ModifyContractInfoRequest info = getModifyContractInfo();
		user.copyContactInfo(info);
		if (!user.getUsername().equals(request.getUsername()) || !user.getRealname().equals(request.getRealname())
				|| !user.getDepartmentId().equals(request.getDepartmentId())
				|| !user.getCompany().equals(request.getCompany()) || !user.getEmail().equals("abc.sohu.com")
				|| !user.getMobile().equals("13388888888")) {
			assertFalse("copy error", true);
		}
		assertTrue("copy success", true);
	}
}