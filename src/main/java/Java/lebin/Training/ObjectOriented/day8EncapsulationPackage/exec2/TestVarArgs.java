package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.exec2;
/**
 * 1.有以下三个方法，分别实现返回姓名和两门课成绩，返回姓名和三门课成绩，返回姓名和五门课成绩。封装成一个可变参数的方法，并调用

 * @author liyuting
 *
 */
public class TestVarArgs {
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		String info = va.getInfo("慕容复", 1,2,3);
		System.out.println(info);
	}

}

class VarArgs{
	/*
	public String getInfo(String name,double a,double b){
		return name+"\t"+a+"\t"+b;
	}
	public String getInfo(String name,double a,double b,double c){
		return name+"\t"+a+"\t"+b+"\t"+c;
	}
	public String getInfo(String name,double a,double b,double c,double d,double e){
		return name+"\t"+a+"\t"+b+"\t"+c+"\t"+d+"\t"+e;
	}*/
	
	public String getInfo(String name,double ...score){
		
		
		for(int i=0;i<score.length;i++){
			name+="\t"+score[i];
		}
		return name;
	}
	
	
}