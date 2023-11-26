package Java.lebin.Training.ObjectOriented.DEMOTEST.exec1;

public class TestMethod {

	public static void main(String[] args) {
		MethodUtils mu = new MethodUtils();
		String[] arr = {"john","lucy","Rose"};
		mu.printArr(arr);
		
		
		Animal a = new Animal();
		a.color="green";
		
		mu.judgeColor(a);
		
	}
}
