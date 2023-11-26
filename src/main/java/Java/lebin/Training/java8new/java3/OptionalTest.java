package Java.lebin.Training.java8new.java3;

import java.util.Optional;
import java.util.jar.Attributes.Name;

import org.junit.Test;

public class OptionalTest {
	
	
	@Test
	public void test2(){
		Optional<Girl> op = Optional.ofNullable(new Girl("dd"));
		String name1 = getGirlName1(Optional.ofNullable(new Man1(op)));
		System.out.println(name1);
		
		
		String name2 = getGirlName1(Optional.ofNullable(null));
		System.out.println(name2);
	}
	
	public String getGirlName1(Optional<Man1> man){
		
		Man1 man1 = man.orElse(new Man1());
		
		Optional<Girl> girl = man1.getGirl();
		
		Girl girl1 = girl.orElse(new Girl("梁静茹"));
		
		return girl1.getName();
		
		
		
	}
	
	
	@Test
	public void test1(){
		
		Man man = new Man();
		man = new Man(new Girl("朱茵"));
		String name = getGirlName(man);
		System.out.println(name);
		
	}
	
	public String getGirlName(Man man){
//		return man.getGirl().getName();
		
		if(man != null){
			Girl girl = man.getGirl();
			
			if(girl != null){
				return girl.getName();
			}
		}
		
		return "苍老师";
	}
	
}	
