package Java.lebin.Training.ObjectOriented.day10Polymorphisn.view;

import Java.lebin.Training.ObjectOriented.day10Polymorphisn.bean.Customer;
import Java.lebin.Training.ObjectOriented.day10Polymorphisn.service.CustomerList;
import Java.lebin.Training.ObjectOriented.day10Polymorphisn.utils.CMUtility;

/**
 * 功能：实现项目的界面展示
 * 
 * @author liyuting
 *
 */
public class CustomerView {
	CustomerList  list = new CustomerList(100);
	public static void main(String[] args) {
		CustomerView v = new CustomerView();
		v.enterMainMenu();
	}
	/**
	 * 主菜单
	 */
	public void enterMainMenu() {
		boolean flag = true;
		do {
			System.out.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                   1 添 加 客 户");
			System.out.println("                   2 修 改 客 户");
			System.out.println("                   3 删 除 客 户");
			System.out.println("                   4 客 户 列 表");
			System.out.println("                   5 退       出\n");
			System.out.print("请选择(1-5)：");
			// 接受键盘输入的菜单
			char key = CMUtility.readMenuSelection();
			switch (key) {
			case '1':
				add();
				break;
			case '2':
				update();
				break;
			case '3':
				delete();

				break;
			case '4':
				showAllCustomers();
				break;
			case '5':
				flag = exit();
				break;
			}

		} while (flag);

	}
	/**
	 * 退出
	 */
	public boolean exit() {
		
		
		System.out.println("确认是否要退出吗？Y/N:");
		char key = CMUtility.readConfirmSelection();
		
		return !(key=='Y');
			

	}
	/**
	 * 增加
	 */
	public void add() {
		
		

	}

	/**
	 * 修改
	 */
	public void update() {
		
		System.out.println("---------------------修改客户---------------------");

		Customer customer =null;
		
		int no;
		for(;;){
			System.out.print("请选择待修改客户编号(-1退出):");
			 no = CMUtility.readInt();
	
			//判断客户编号是否存在
	
			//调用CustomerList类的查找客户的方法
			
			
			 customer = list.getCustomer(no-1);
			if(customer!=null){
				break;
			}
			System.out.println("无法找到指定客户！");
		}
				
		System.out.print("姓名("+customer.getName()+")：");
		String name = CMUtility.readString(8, customer.getName());
		System.out.print("性别("+customer.getGender()+"):");
		char gender = CMUtility.readChar(customer.getGender());
		System.out.print("年龄("+customer.getAge()+"):");
		int age = CMUtility.readInt(customer.getAge());
		System.out.print("电话("+customer.getPhone()+")：");
		String phone = CMUtility.readString(11, customer.getPhone());
		System.out.print("邮箱("+customer.getEmail()+")：");
		String email = CMUtility.readString(20, customer.getEmail());
		
		
		//--------------------------修改----------------------------
		Customer newCustomer = new Customer(no, name, gender, age, phone, email);
		
		boolean replaceCustomer = list.replaceCustomer(no-1, newCustomer);
		if (replaceCustomer) {
			System.out.println("---------------------修改完成---------------------");
		} else {
			System.out.println("---------------------修改失败---------------------");

		}
	}

	/**
	 * 删除
	 */
	public void delete() {

	}

	/**
	 * 查看客户列表
	 */
	public void showAllCustomers() {
		
		Customer[] allCustomers = list.getAllCustomers();
		for (int i = 0; i < allCustomers.length; i++) {
			
			System.out.println(allCustomers[i].getInfo());
		}
		
		

	}



}
