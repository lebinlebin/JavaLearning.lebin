package Java.lebin.Training.ObjectOriented.day9Inheritance.bean;

public class Computer {
	private String brand;
	private double price;
	public void setBrand(String b){
		brand=b;
	}
	public String getBrand(){
		return brand;
	}
	
	public void setPrice(double p){
		price = p;
	}
	public double getPrice(){
		return price;
	}

	public String show(){
		return brand+"\t"+price;
	}
}
