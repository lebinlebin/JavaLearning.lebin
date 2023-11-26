package Java.lebin.Training.netWork.utils;

import java.io.*;

/**
 * 此类用于封装一个IO流读写的工具类
 * @author liulebin
 *
 */
public class StreamUtils {
	
	/**
	 * 功能：将字节输入流读取后，转换成String
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static String streamToString(InputStream is) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder=new StringBuilder();
		String line;
		while((line=reader.readLine())!=null){
			builder.append(line);
			
		}
		
		return builder.toString();
		
	}
	
	/**
	 * 功能：将字节输入流读取后，转换成byte[]
	 * @param is
	 * @return
	 * @throws IOException 
	 */
	public static byte[] streamToByteArray(InputStream is) throws IOException{
		ByteArrayOutputStream  baos = new ByteArrayOutputStream();
		int len;
		byte[] b = new byte[1024];
		while((len=is.read(b))!=-1){
			baos.write(b, 0, len);
			
		}
		
		return baos.toByteArray();
		
		
		
	}
	

}
