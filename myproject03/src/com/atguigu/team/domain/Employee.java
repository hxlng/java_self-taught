package com.atguigu.team.domain;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private double salary; //工资
	
	public Employee() {
		super();
	}
	
	public Employee(int id,String name,int age,double salary) {
		super();
		this.id=id;
		this.name=name;
		this.age=age;
		this.salary=salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	protected String getDetails() {  //写此方法 避免间接子类无法调用本类从写的toString
		return id + "\t"+ name +"\t" +age+ "\t" +salary;
	}
	@Override
	public String toString() {
		return getDetails();
	}

}
