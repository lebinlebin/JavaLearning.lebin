package Java.lebin.Training.Exception.exec2;

public class TestException1 {
	public static int method() {
		int i = 10;
		try {
			String[] names = new String[3];
			i++;// 11

			if (names[1].equals("john")) {// 空指针
				System.out.println(names[1]);
			} else {
				names[3] = "lucy";
			}
			return i;
		} catch (ArrayIndexOutOfBoundsException e) {

			return ++i;

		} catch (NullPointerException e) {

			return ++i;// 12
		} finally {
			i = 999;
			System.out.println(i);
			// return i++;
		}
	}

	public static void main(String[] args) {

		System.out.println(method());
	}
}