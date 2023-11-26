package Java.lebin.Training.ObjectOriented.day12AbstractClassInterface.exec3;
//用于练习接口的定义和使用
public class TestInterface1 {

}
class Kua implements Runner{

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	
}
interface Swimmer{
	void swim();
}

interface Runner extends Swimmer{
	
}
interface StudyEnglish{
	void studyEnglish();
}

abstract class Student implements Runner{
	String name;
	public abstract void study();
}
class Colledge extends Student implements StudyEnglish{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void studyEnglish() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	
}
class MiddleSchoolStudent extends Student{

	@Override
	public void study() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		
	}
	
}
abstract class Sporter{
	public abstract void sport();
}

class BasketBaller extends Sporter implements StudyEnglish{

	@Override
	public void sport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void studyEnglish() {
		// TODO Auto-generated method stub
		
	}
	
}


class FootBaller extends Sporter{

	@Override
	public void sport() {
		// TODO Auto-generated method stub
		
	}
	
}
