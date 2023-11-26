package Java.lebin.Training.FileSys.Properties;

import java.io.File;
import java.io.InputStream;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

public class TestClassLoader {
    public static void main(String[] args) {

        System.out.println(TestClassLoader.class.getResource("/zhaopin.conf/zhaopinyouxuanDeepFM.properties"));
        System.out.println(TestClassLoader.class.getClassLoader().getResource("zhaopin.conf/zhaopinyouxuanDeepFM.properties"));



        //报错空指针
        System.out.println(TestClassLoader.class.getResource("zhaopin.conf/zhaopinyouxuanDeepFM.properties"));
        System.out.println();
        //报错空指针
        System.out.println(TestClassLoader.class.getClassLoader().getResource("/zhaopin.conf/zhaopinyouxuanDeepFM.properties"));
    }
}