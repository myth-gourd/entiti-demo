package com.github.myth.gourd.entiti.demo.pojo;

import java.util.Date;

import com.github.myth.gourd.entiti.demo.pojo.request.AddUserRequest;
import com.github.myth.gourd.entiti.demo.pojo.request.ModifyContractInfoRequest;

import lombok.Data;
import myth.gourd.entiti.errors.exception.ValidateErrorException;
import myth.gourd.entiti.innotation.Copy;
import myth.gourd.entiti.innotation.CopyIgnore;
import myth.gourd.entiti.innotation.Default;
import myth.gourd.entiti.innotation.DefaultObject;
import myth.gourd.entiti.innotation.DefaultValue;
import myth.gourd.entiti.innotation.Field;
import myth.gourd.entiti.innotation.Validate;
import myth.gourd.entiti.innotation.ValidateNotEmpty;
import myth.gourd.entiti.innotation.ValidateNotNull;
import myth.gourd.entiti.innotation.ValidateSize;

@Data
public class User {

	@DefaultObject(value="java.util.UUID.randomUUID().toString()")
	private String id;
	
	@Field(title="用户名")
	@ValidateSize(max=10)
	@ValidateNotEmpty
	private String username;
	
	@Field(title="真实姓名")
	@ValidateSize(max=10)
	@ValidateNotNull
	private String realname;
	
	@Field(title="公司")
	private String company;
	
	@Field(title="邮箱", groups ="ContactInfo")
	@DefaultValue(value="", fixed=true)
	private String email;
	
	@Field(title="手机", groups ="ContactInfo")
	@DefaultValue(value="", fixed=true)
	private String mobile;
	
	@Field(title="部门Id")
	@DefaultValue(value="")
	private String departmentId;
	
	@Field(title="头像")
	@DefaultValue(value="default.jpg")
	private String headPortrait;
	
	@CopyIgnore
	@Field(title="建立日期")
	private Date createTime;
	
	@Copy
	public void copy(AddUserRequest user){}
	
	@Copy(groups="ContactInfo")
	public void copyContactInfo(ModifyContractInfoRequest info){}
	
	@Default
	public void defaults(){
	}

	@Validate(code="201")
	public void validate() throws ValidateErrorException
	{
	}
}
