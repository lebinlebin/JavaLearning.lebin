package Java.lebin.Training.ObjectOriented.day10Polymorphisn.service;

import java.util.Arrays;

import Java.lebin.Training.ObjectOriented.day10Polymorphisn.bean.Customer;

/**
 * 功能：业务模块，不涉及任何的输入输出！
 * @author liulebin
 * 作用：用于管理一组客户对象，实现客户对象的增删改查
 * 
 * 属性：
 *	 客户数组
 * 方法：
 * 	增加客户的方法
 * 	修改客户的方法
 * 	删除客户的方法
 * 	返回所有客户的方法
 * 
 *
 */
public class CustomerList {
	
	//属性
	Customer[]  customers;//①数组的声明
	int total = 1;//记录待添加的位置（下标）&存储的客户的实际个数
	
	//构造器
	public CustomerList(int totalList){
		//②开辟空间
		customers = new Customer[totalList];
		
		//③赋值
		
		customers[0] = new Customer(1, "张三", '男', 20, "010-123456", "zhangsan@126.com");
		
		
	}
	/**
	 * 功能：添加新客户
	 * @param newCustomer 待添加的客户对象
	 * @return 添加成功与否
	 */
	public boolean addCustomer(Customer newCustomer){
		if(total >=customers.length)
			return false;
		
		customers[total++]=newCustomer;//赋值
		return true;
	}
	/**
	 * 功能：修改客户
	 * @param index 要修改的客户的下标
	 * @param newCustomer 新客户对象
	 * @return 修改成功与否
	 */
	public boolean replaceCustomer(int index,Customer newCustomer){
		if(index<0||index>=total)
			return false;
		
		customers[index]=newCustomer;
		return true;
	}
	/**
	 * 功能：删除指定索引处的客户对象
	 * @param index 待删除的客户的索引
	 * @return 删除成功与否
	 */
	public boolean deleteCustomer(int index){
		if(index<0||index>=total)
			return false;
		for(int i=index;i<total-1;i++){
			customers[i] = customers[i+1];
		}
		//最后一个实际元素置空&total更新
		customers[--total] = null;
		
		return true;
	}
	/**
	 * 功能：返回所有客户
	 *
	 * @return 所有客户
	 */
	public Customer[] getAllCustomers(){
		
//		Customer[] newCustomers = new Customer[total];
//		for (int i = 0; i < total; i++) {
//			newCustomers[i]=customers[i];
//		}
		
		return  Arrays.copyOf(customers, total);
	}
	/**
	 * 功能：根据指定索引，返回客户对象
	 * @param index 待查找的索引
	 * @return 客户对象，如果找不到，则返回null
	 */
	public Customer getCustomer(int index){
		
		if(index<0||index>=total)
			return null;
		return customers[index];
		
	}
	

}
