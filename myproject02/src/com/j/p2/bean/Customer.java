package com.j.p2.bean;

/**
 * 
* @Description Customer为实体对象，用来封装客户信息
* @author xfy Email:3460760968@qq.com
* @version
* @date 2021年4月18日上午8:56:52
*
 */
public class Customer {
	private String name; //客户姓名
	private char gender; //性别
	private int age; //年龄
	private String phone; //电话号码
	private String email;//电子邮件
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public char getGender(){
		return gender;
	}
	public void setGender(char gender){
		this.gender=gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(){
		
	}

	public Customer(String name, char gender, int age, String phone, String email) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}
	
}
