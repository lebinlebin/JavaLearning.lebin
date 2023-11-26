package Java.lebin.Training.ObjectOriented.DEMOTEST.demo5;

public class TestPolyArguments2 {

	public static void main(String[] args) {
		Women w = new Women();
		w.feed(new Cat2());
		w.feed(new Dog2());

		w.train(new Cat2());
		w.train(new Dog2());


	}

}
class Women{
	/**
	 * 喂食行为
	 * @param a
	 */
	public void feed(Animal2 a){
		a.eat();
	}
	/**
	 * 训练技能
	 * @param a
	 */
	public void train(Animal2 a){
		if(a instanceof Cat2){
			System.out.println("猫捉老鼠");

		}else if(a instanceof Dog2){
			System.out.println("狗看门");
		}


	}

}
class Animal2{
	public void eat(){
		System.out.println("动物吃");
	}
}
class Cat2 extends Animal2{
	@Override
	public void eat(){
		System.out.println("猫吃鱼");
	}
}
class Dog2 extends Animal2{
	@Override
	public void eat(){
		System.out.println("狗吃骨头");
	}
}
