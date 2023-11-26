package Java.lebin.Training.Exception.exec2;

import java.io.FileInputStream;
import java.io.IOException;

public class TestException2 {

	public static void main(String[] args) {
//		FileInputStream in = null;
//		try{
//			 in=new FileInputStream("myfile.txt");
//			int b;	
//			b = in.read();
//			while(b!= -1)       {
//				System.out.print((char)b);
//				b = in.read();
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//			
//		}finally{
//			try{
//				in.close();
//			}catch(Exception ex){
//				ex.printStackTrace();
//			}
//		}
		//方式二：alt+shift+z可以自动生成try catch
		FileInputStream in=null;
		try {
			in = new FileInputStream("myfile.txt");
			int b;	
			b = in.read();
			while(b!= -1)       {
				System.out.print((char)b);
				b = in.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
