package com.github.myth.gourd.entiti.demo.pojo.request;

import lombok.Data;

@Data
public class AddUserRequest {
	private String username;
	private String realname;
	private String company;
	private String email;
	private String mobile;
	private String departmentId;
}
