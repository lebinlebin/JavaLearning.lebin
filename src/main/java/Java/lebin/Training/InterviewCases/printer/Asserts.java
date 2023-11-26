package Java.lebin.Training.InterviewCases.printer;

public class Asserts {
	public static void test(boolean v) {
		if (v) return;
		System.err.println(new RuntimeException().getStackTrace()[1]);
	}
}

