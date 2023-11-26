package Java.lebin.Training.ObjectOriented.day8EncapsulationPackage.demo.encap;

public class TestGirl {
	public static void main(String[] args) {
		Girl g = new Girl();
		g.name="高圆圆";
//		g.age=-9999;
		
		g.setAge(-9999);
		System.out.println(g.getInfo());
		System.out.println(g.getAge());
		if(g.getAge()>18){
			
		}
		
	}

}
