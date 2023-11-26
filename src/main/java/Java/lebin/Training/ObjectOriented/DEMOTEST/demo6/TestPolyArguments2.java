package Java.lebin.Training.ObjectOriented.DEMOTEST.demo6;

public class TestPolyArguments2 {
	
	public static void main(String[] args) {
		Women w = new Women();
		w.feed(new Cat());
		w.feed(new Dog());
		
		w.train(new Cat());
		w.train(new Dog());
		
		
	}

}
class Women{
	/**
	 * 喂食行为
	 * @param a
	 */
	public void feed(Animal a){
		a.eat();
		
	}
	/**
	 * 训练既能
	 * @param a
	 */
	public void train(Animal a){
		if(a instanceof Cat){
			System.out.println("猫抓老鼠");
			
		}else if(a instanceof Dog){
			System.out.println("狗看门");
		}
		
		
	}
	
}
class Animal{
	public void eat(){
		System.out.println("动物吃");
	}
}
class Cat extends Animal{
	public void eat(){
		System.out.println("猫吃鱼");
	}
	
	
}
class Dog extends Animal{
	public void eat(){
		System.out.println("狗吃骨头");
	}
}
