package Java.lebin.Training.Annotation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit中的基本注解
 * Junit中集中基本注解，是必须掌握的。
 * •	@BeforeClass – 表示在类中的任意public static void方法执行之前执行
 * •	@AfterClass – 表示在类中的任意public static void方法执行之后执行
 * •	@Before – 表示在任意使用@Test注解标注的public void方法执行之前执行
 * •	@After – 表示在任意使用@Test注解标注的public void方法执行之后执行
 * •	@Test – 使用该注解标注的public void方法会表示为一个测试方法
 *
 *
 */
public class BasicAnnotationTest {
    // Run once, e.g. Database connection, connection pool
    @BeforeClass
    public static void runOnceBeforeClass() {
        System.out.println("@BeforeClass - runOnceBeforeClass");
    }

    // Run once, e.g close connection, cleanup
    @AfterClass
    public static void runOnceAfterClass() {
        System.out.println("@AfterClass - runOnceAfterClass");
    }

    // Should rename to @BeforeTestMethod
    // e.g. Creating an similar object and share for all @Test
    @Before
    public void runBeforeTestMethod() {
        System.out.println("@Before - runBeforeTestMethod");
    }

    // Should rename to @AfterTestMethod
    @After
    public void runAfterTestMethod() {
        System.out.println("@After - runAfterTestMethod");
    }

    @Test
    public void test_method_1() {
        System.out.println("@Test - test_method_1");
    }

    @Test
    public void test_method_2() {
        System.out.println("@Test - test_method_2");
    }

}
