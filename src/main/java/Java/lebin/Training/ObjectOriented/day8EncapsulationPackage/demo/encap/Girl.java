package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.demo.encap;

public class Girl {
	String name;
	private int age;//步骤1：将需要封装的属性私有化
	
	public void setAge(int a){//步骤2：提供一个公共的set方法，为age赋值
		
		if(a>=0&&a<=120)
			age=a;
		else
			age=18;
	}
	
	public int getAge(){//步骤3：提供一个公共的get方法，供外部类访问
		return age;
	}
	
	public String getInfo(){
		return name+"\t"+age;
	}

}
