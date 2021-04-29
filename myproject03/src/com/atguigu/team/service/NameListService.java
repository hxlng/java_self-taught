package com.atguigu.team.service;

import com.atguigu.team.domain.*;


import static com.atguigu.team.service.Data.*;

public class NameListService {
	
	private Employee[] employees;
	
	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		
		for(int i=0;i<employees.length;i++) {
			//获取通用的属性
			int type=Integer.parseInt(EMPLOYEES[i][0]);
			int id =Integer.parseInt(EMPLOYEES[i][1]);
			String name=EMPLOYEES[i][2];
			int age =Integer.parseInt(EMPLOYEES[i][3]);
			double salary=Double.parseDouble(EMPLOYEES[i][4]);
			Equipment eq;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i]=new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				eq=creatEquipment(i); //获取设备属性有多个不能不能一句完成
				employees[i]=new Programmer(id, name, age, salary, eq);
				break;
			case DESIGNER:
				eq=creatEquipment(i);
				bonus=Integer.parseInt(EMPLOYEES[i][5]);
				employees[i]=new Designer(id, name, age, salary, eq, bonus);
						
				break;
			case ARCHITECT:
				eq=creatEquipment(i);
				bonus=Integer.parseInt(EMPLOYEES[i][5]);
				stock=Integer.parseInt(EMPLOYEES[i][6]);
				employees[i]=new Architect(id, name, age, salary, eq, bonus, stock);
				break;
				
			}
			
		}
		
		
	}
	
	
	//获取指定index员工设备
	private Equipment creatEquipment(int index) {
		int type=Integer.parseInt(EQUIPMENTS[index][0]);
		switch(type){
			case PC:
				return new PC(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
			case NOTEBOOK:
				int price=Integer.parseInt(EQUIPMENTS[index][2]);
				return new NoteBook(EQUIPMENTS[index][1],price);
			case PRINTER:
				return new Printer(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
		}
		return null;
	}


	public Employee[] getAllEmployees() {
		return employees;
	}
	
	public Employee getEmployee(int id) throws TeamException {
		
		for(int i=0;i<employees.length;i++) {
			if(employees[i].getId()==id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}
}
