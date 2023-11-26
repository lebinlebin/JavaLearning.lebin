package Java.lebin.Training.FileSys.File.deletFileDirLoop;

import java.io.File;
import java.math.BigInteger;

/**
 * 使用递归实现，删除一个指定目录（不管里面有无子级）
 * @author liulebin
 *
 */
public class TestHomework {
	
	public static void main(String[] args) {
		System.out.println(factorial(new BigInteger("100")));
//		File file = new File("E:\\demo");
//		
//		deleteDirectory(file);
		System.out.println(jiecheng(20));
		
	}

	private static void deleteDirectory(File file) {
		boolean delete = file.delete();//demo
		
		if(!delete){
			File[] listFiles = file.listFiles();//a
			
			for (File subFile : listFiles) {
				deleteDirectory(subFile);
			}
			
			file.delete();
			
		}
	}
	
	public static Long  jiecheng(int num){
		if(num==1){
			return 1L;
		}else {
			return num*jiecheng(num-1);
		}

	}


	public static BigInteger factorial(BigInteger num) {
		if (num.equals(BigInteger.ONE) || num.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		return num.multiply((factorial(num.subtract(BigInteger.ONE ))));

	}

}
