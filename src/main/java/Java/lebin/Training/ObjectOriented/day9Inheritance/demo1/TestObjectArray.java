package Java.lebin.Training.ObjectOriented.day9Inheritance.demo1;

import Java.lebin.Training.ObjectOriented.day9Inheritance.bean.Animal;

/**
 * 此类用于演示对象数组的动态初始化
 * @author liyuting
 *案例：定义Animal 数组，保存三个小动物，并调用小动物显示信息的方法
Animal类的属性：名称、年龄、颜色

 */
public class TestObjectArray {

	
	public static void main(String[] args) {
//		1、声明并开辟空间
		Animal[] animals = new Animal[3];
		
//		2、赋值
		animals[0]=new Animal();
		animals[0].setAge(2);
		animals[0].setName("小白");
		animals[0].setWeight(100);
		
		animals[1]=new Animal();
		animals[1].setAge(3);
		animals[1].setName("小绿");
		animals[1].setWeight(100);
		
		
		animals[2]=new Animal();
		animals[2].setAge(4);
		animals[2].setName("小花");
		animals[2].setWeight(100);
		
		
//		3、循环遍历数组中的每一个元素
		
		for(int i=0;i<animals.length;i++){
			
//			System.out.println(animals[i].getName()+"\t"+animals[i].getAge()+"\t"+animals[i].getColor());
			animals[i].show();
		}
		
	}
}
