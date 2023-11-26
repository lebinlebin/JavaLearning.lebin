package Java.lebin.Training.FileSys.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestIo {
    public static void main(String[] args) throws IOException {
        //1.创建流对象（用于读取键盘输入的数据）
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //循环读取
        String line;
        while(true){
            System.out.println("请输入字符串:");
            line = reader.readLine();
            if("e".equals(line)||"exit".equals(line))
                break;
            System.out.println(line.toUpperCase());
        }
        //3. 关闭
        reader.close();
    }
}
