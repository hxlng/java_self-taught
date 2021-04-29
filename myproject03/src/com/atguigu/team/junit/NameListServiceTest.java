package com.atguigu.team.junit;

import org.junit.Test;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;

public class NameListServiceTest {
	@Test
	public void testGetAllEmployees() {
		NameListService service=new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(Employee e: employees) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service=new NameListService();
		int id=101;
		
		try {
			Employee employee=service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
