package Java.lebin.Training.java8new.java;

public class FilterEmployeesBySalary implements MyPredicate<Employee>{

	@Override
	public boolean test(Employee t) {
		return t.getSalary() > 5000;
	}

}
