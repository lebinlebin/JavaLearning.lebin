package Java.lebin.Training.ObjectOriented.day7ClassAndMethod.demo1;
/*
 * 
 * 在TestStudent类中创建三个Student对象，第一个对象只对name赋值，
 * 第二个对象只对gender和age赋值，第三个对象都赋值。调用say方法和所有属性

 */
public class TestStudent {
	
	public static void main(String[] args) {
		//第一个对象
		Student s = new Student();
		
		s.name="钟灵";
		
		
		s.say();
		
		//第二个对象
		Student s2 = new Student();
		s2.gender="女";
		s2.age=19;
		s2.say();
		
		
		//第三个对象
		Student s3 = new Student();
		s3.name="段誉";
		s3.age=16;
		s3.score=100;
		s3.id=1;
		s3.gender="男";
		s3.say();
		
		
	}

}
