package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;
/**
 * 此类用于演示多态数组的使用
 * @author liulebin
 * 案例1：
 * 要求创建五个年龄不等的Person、Student和Teacher对象，并将他们按年龄排序输出，应如何实现？
	进阶：
	
	ctrl+1
	alt+/
 *
 */
public class TestPolyArray {
	
	public static void main(String[] args) {
		//1.声明并开辟空间
		Person[] pers = new Person[5];
		
		//2.赋值
		pers[0]=new Person("段誉",20);
		pers[1]=new Student("王语嫣",21, 98.5);
		pers[2]=new Student("慕容复",25,59.9);
		pers[3]=new Teacher("逍遥子",120,10000);
		pers[4]=new Teacher("李秋水",108,29000);
		
		//3.使用
		
		for (int i = 0; i < pers.length; i++) {
			System.out.println(pers[i].getInfo());
		}
		
		//排序 按照年龄排序
		
		for(int i=0; i<pers.length-1; i++){
			for(int j=0; j<pers.length-1-i; j++){
				if(pers[j].getAge()>pers[j+1].getAge()){
					Person temp = pers[j];
					pers[j]=pers[j+1];
					pers[j+1]=temp;
				}
			}
		}
		//排序后
		System.out.println("排序后");
		for (int i = 0; i < pers.length; i++) {
			System.out.println(pers[i].getInfo());
		}
		System.out.println("-------------------------------");
		
		//进阶2：遍历多态数组，如果元素类型为Person，希望调用work；如果元素类型为Teacher，希望调用teach，如果元素类型为Student，希望调用study
		/*
		 * 语法：对象 instanceof 类型 A  
		 * 应用场景：一般放在if条件中，可以返回：true|false
		 * 功能：判断对象的实际运行类型是否为A类型或A的子类型
		 * 示例：
		 * Person s = new Person();
		 * 
		 * if(s instanceof Student){}
		 */
		for(int i=0;i<pers.length;i++){
			
			
			
			//判断元素的实际运行类型是否为Teacher类型，如果是，执行下一步
			if(pers[i] instanceof Teacher){
				Teacher t = (Teacher) pers[i];
				t.teach();
			}
			//判断元素的实际运行类型是否为Stduent类型，如果是，执行下一步
			else if(pers[i] instanceof Student){
				Student s = (Student) pers[i];
				
				s.study();
				
			}
			
			//判断元素的实际运行类型是否为Person类型，如果是，执行下一步
			else{
				pers[i].work();
			}
		}
		
		
		
		
		
	}

}
