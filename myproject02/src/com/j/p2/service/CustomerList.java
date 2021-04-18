package com.j.p2.service;

import com.j.p2.bean.Customer;

/**
 * 
* @Description CustomerList为Customer对象的管理模块，
* 				内部用数组管理一组Customer对象，并提供相应的添加、修改、删除和遍历方法。提供CustomerView调用。
* @author xfy Email:3460760968@qq.com
* @version
* @date 2021年4月18日上午9:13:20
*
 */
public class CustomerList {
	private Customer[] customers;//用来保存客户对象的数组
	private int total; //记录已保存客户对象的数量
	
	/**
	 * 用来初始化customers数组的构造器
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers=new Customer[totalCustomer];
	}
	/**
	 * 
	* @Description 将指定的客户添加到数组中
	* @author xfy
	* @date 2021年4月18日上午9:40:04
	* @param customer
	* @return true:添加成功 false：添加失败
	 */
	public boolean addCustomer(Customer customer){
		if(total>=customers.length){
			return false;
		}
		
//		customers[total]=customer;
//		total++;
		//或
		customers[total++]=customer;
		return true;
	} 
	/**
	 * 
	* @Description 修改指定索引位置的客户信息
	* @author xfy
	* @date 2021年4月18日上午9:46:23
	* @param index
	* @param cust
	* @return true:修改成功 false：修改失败
	 */
	public boolean replaceCustomer(int index, Customer cust){
		if(index<0||index>=total){
			return false;
		}
		customers[index]=cust;
		return true;
	}
	/**
	 * 
	* @Description   删除指定索引位置上的客户
	* @author xfy
	* @date 2021年4月18日上午9:51:01
	* @param index
	* @return true：删除成功 false：删除失败
	 */
	public boolean deleteCustomer(int index){
		if(index<0||index>=total){
			return false;
		}
		for(int i=index;i<total-1;i++){  //删除后把后面的数组往前移
			customers[i]=customers[i+1];
		}
		//最后有数据的元素需要置空
//		customers[total-1]=null;
//		total--;
		//或
		customers[--total]=null;
		return true;
	}
	/**
	 * 
	* @Description 获取所有的客户信息
	* @author xfy
	* @date 2021年4月18日上午9:30:42
	* @return
	 */
	public Customer[] getAllCustomers(){
		//return customers;
		
		Customer[] custs=new Customer[total];
		for(int i=0;i<total;i++){
			custs[i]=customers[i];
		}
		return custs;
	} 
	/**
	 * 
	* @Description 获取指定索引位置上的客户
	* @author xfy
	* @date 2021年4月18日上午10:03:00
	* @param index
	* @return 如果找到元素，则返回；如果没有找到，则返回null
	 */
	public Customer getCustomer(int index) {
		if(index<0||index>=total){
			return null;
		}
		return customers[index];
	}
	/**
	 * 
	* @Description 获取存储的客户的数量
	* @author xfy
	* @date 2021年4月18日上午10:06:53
	* @return
	 */
	public int getTotal(){
		return total;
		//return customers.length; //错误的
	}

}
