package Java.lebin.Training.FileSys.Properties;


import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class testProperties{
    @Test
    public void setAndGetProperty() {
        Properties pro = new Properties();
        //设置值
        pro.setProperty("driver", "com.mysql.jdbc.Driver");
        pro.setProperty("url", "jdbc:mysql///user");
        pro.setProperty("user", "root");
        pro.setProperty("password", "451535");
        //获取值：
        //1、getProperty(String key)方法  通过键获取值
        String str = pro.getProperty("driver");
        System.out.println(str);
        //2、getProperty(String key, String defaultValue)重载方法
        //当properties对象中没有所指定的键值时，显示给定的默认值
        String str2 = pro.getProperty("driver", "没有该值");
        String str3 = pro.getProperty("haha", "没有该值");
        System.out.println(str2);
        System.out.println(str3);

    }
    /*2.以properties配置文件格式写入到硬盘中的某个文件夹（本例写入到D盘的others文件夹中）：*/
    @Test
    public void storePropertiesToHardFile() throws FileNotFoundException, IOException {
        Properties pro=new Properties();
        pro.setProperty("driver", "com.mysql.jdbc.Driver");
        pro.setProperty("url", "jdbc:mysql///user");
        pro.setProperty("user", "root");
        pro.setProperty("password", "451535");
        //1.通过字节流的形式
        //store(OutputStream out, String comments)
        //outputStream:字节输出流   comments：配置文件说明
        pro.store(new FileOutputStream(new File("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/database.properties")), "数据库配置文件");

        //2.通过字符流的形式
        //store(Writer writer, String comments)
        //writer:字符输出流   comments：配置文件说明
        pro.store(new FileWriter("/Users/liulebin/Documents/codeing/JAVA_SCALA_PYTHON_LEARNING/JavaBasicCode/Filedata/jdbc.properties"),  "数据库配置文件");
    }


    public static void main(String[] args) {

    }
}

