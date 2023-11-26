package Java.lebin.Training.ObjectOriented.day9Inheritance.demo1;


import Java.lebin.Training.ObjectOriented.day9Inheritance.bean.Animal;

/**
 * 此类用于演示对象数组的静态初始化
 * @author liulebin
 *案例：定义Animal 数组，保存三个小动物，并调用小动物显示信息的方法
Animal类的属性：名称、年龄、颜色

 */
public class TestObjectArray2 {
	public static void main(String[] args) {
		//1.声明并初始化
		
		Animal a1 = new Animal();
		a1.setName("小翠");
		a1.setAge(3);
		a1.setColor("花色");
		a1.setWeight(90);
		Animal[] animals = {a1,new Animal(),new Animal()};
		
		
		//2。使用
		for (int i = 0; i < animals.length; i++) {
			animals[i].show();
		}
	}

}
