package Java.lebin.Training.DSA._00_complexity;

public class Main {
    public Main() {
    }

    public static int fib1(int n) {
        return n <= 1 ? n : fib1(n - 1) + fib1(n - 2);
    }

    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        } else {
            int first = 0;
            int second = 1;

            for(int i = 0; i < n - 1; ++i) {
                int sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        }
    }

    public static int fib3(int n) {
        if (n <= 1) {
            return n;
        } else {
            int first = 0;
            int second;
            for(second = 1; n-- > 1; first = second - first) {
                second += first;
            }
            return second;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(fib2(n));
        System.out.println(fib3(n));
        Times.test("fib1", new Times.Task() {
            @Override
            public void execute() {
                System.out.println(fib1(n));
            }
        });
    }

    public static void test1(int n) {
        if (n > 10) {
            System.out.println("n > 10");
        } else if (n > 5) {
            System.out.println("n > 5");
        } else {
            System.out.println("n <= 5");
        }

        for(int i = 0; i < 4; ++i) {
            System.out.println("test");
        }

    }

    public static void test2(int n) {
        for(int i = 0; i < n; ++i) {
            System.out.println("test");
        }

    }

    public static void test3(int n) {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                System.out.println("test");
            }
        }

    }

    public static void test4(int n) {
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < 15; ++j) {
                System.out.println("test");
            }
        }

    }

    public static void test5(int n) {
        while((n /= 2) > 0) {
            System.out.println("test");
        }

    }

    public static void test6(int n) {
        while((n /= 5) > 0) {
            System.out.println("test");
        }

    }

    public static void test7(int n) {
        for(int i = 1; i < n; i *= 2) {
            for(int j = 0; j < n; ++j) {
                System.out.println("test");
            }
        }

    }

    public static void test10(int n) {
        int a = 10;
        int b = 20;
        int c = a + b;
        int[] array = new int[n];

        for(int i = 0; i < array.length; ++i) {
            System.out.println(array[i] + c);
        }

    }
}
