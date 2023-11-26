package Java.lebin.Training.ObjectOriented.day13EnumsInnerClass.execinner;
/*
 * 有一个Car类，有属性temperature（温度），车内有Air（空调）类，
 * 
 * 有吹风的功能flow，Air会监视车内的温度，如果温度超过40度则吹冷气。如果温度低于0度则吹暖气，
 * 如果在这之间则关掉空调。实例化具有不同温度的Car对象，调用空调的flow方法，测试空调吹的风是否正确
 */
public class TestInner1 {
	public static void main(String[] args) {
		Car c1= new Car(100);
//		c1.new Air().flow();
		c1.getAir().flow();
		
		
		Car c2 = new Car(-3);
		c2.getAir().flow();
	}

}

class Car{
	
	private double temperature;
	
	public Car(double temperature) {
		super();
		this.temperature = temperature;
	}
	public Air getAir(){
		return new Air();
	}

	class Air{
		public void flow(){
			if (temperature>40) {
				System.out.println("吹冷气");
			} else if(temperature<0){
				System.out.println("吹暖气");
			}else{
				System.out.println("关掉");
			}
			
		}
		
		
	}
}