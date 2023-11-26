package Java.lebin.Training.java8new.java3;

public class Man {
	
	private Girl girl;

	public Man() {
		super();
	}

	public Man(Girl girl) {
		super();
		this.girl = girl;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

	@Override
	public String toString() {
		return "Man [girl=" + girl + "]";
	}
	
	
	
}
