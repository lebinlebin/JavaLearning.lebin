package Java.lebin.Training.java8new.java3;

import java.util.Optional;

public class Man1 {
	
	private Optional<Girl> girl = Optional.empty();

	public Man1() {
		super();
	}

	public Man1(Optional<Girl> girl) {
		super();
		this.girl = girl;
	}

	public Optional<Girl> getGirl() {
		return girl;
	}

	public void setGirl(Optional<Girl> girl) {
		this.girl = girl;
	}

	@Override
	public String toString() {
		return "Man1 [girl=" + girl + "]";
	}
	
	
}
