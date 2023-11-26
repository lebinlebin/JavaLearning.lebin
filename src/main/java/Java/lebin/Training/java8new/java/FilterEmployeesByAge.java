package Java.lebin.Training.java8new.java;

public class FilterEmployeesByAge implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getAge() > 30;
	}

}
