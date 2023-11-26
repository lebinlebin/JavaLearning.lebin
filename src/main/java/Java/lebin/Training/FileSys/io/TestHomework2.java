package Java.lebin.Training.FileSys.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//2.【选作】自定义MyBufferedReader类，里面定义myReadline方法实现读取一行的功能，定义close方法实现关闭流的方法
public class TestHomework2 {

	
	public static void main(String[] args) throws IOException {
		
		
		MyBufferedReader br = new MyBufferedReader(new FileReader("src\\测试题20.txt"));
		
		String line ;
		while((line=br.myReaderLine())!=null){
			System.out.println(line);
		}
		
		br.close();
	}
}


class MyBufferedReader extends Reader{
	
	Reader in;

	public MyBufferedReader(Reader in) {
		this.in=in;
	}
	/**
	 * 功能：读取一行
	 * @return
	 * @throws IOException
	 */

	public String myReaderLine()  throws IOException{
		int len;
		StringBuilder builder  = new StringBuilder();
		while((len=in.read())!=-1){
			
			if((char)len=='\r')
				continue;
			
			if((char)len=='\n')
				return builder.toString();
			
			builder.append((char)len);
			
		}
		
		return null;
		
		
	}
	
	
	
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return in.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		in.close();
		
	}
	
	
	
	
	
}