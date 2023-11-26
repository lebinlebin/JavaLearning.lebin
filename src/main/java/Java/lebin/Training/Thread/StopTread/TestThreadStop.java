package Java.lebin.Training.Thread.StopTread;
/**
 * 此类用于演示线程的停止
 * @author liulebin
 * 1.stop 已经过时
 * 2.Interrupt 只能中断睡眠、等待这些状态，会抛出InterruptedException异常,并没有真正的结束线程
 * 3.采用通知的方法 ★
 * 
 * 	步骤1：让需要停止的线程中添加一个循环标记，默认值为true
 * 	步骤2：让需要停止的线程中添加一个公共的set方法，用于更新循环标记
 * 	步骤3：需要停止该线程时，调用set方法即可
 *
 */
public class TestThreadStop {
	
	public static void main(String[] args) {
		
		
		StopThread st = new StopThread();
		st.start();
		for(int i=1;i<=100;i++){
			
			System.out.println("小花在看电影~"+i);
			if(i==5){
				
				//中断StopThread线程
				st.setFlag(false);
				break;
			}
		}
	}

}


class StopThread extends Thread{
	boolean flag = true;
	
	@Override
	public void run() {
		
		while(flag){
			
			System.out.println("肖强和小黄约会ing,O(∩_∩)O哈哈~");
			
			
		}
	}
	/*
	 * 功能：可以更新循环变量标记
	 */
	public void setFlag(boolean flag){
		this.flag=flag;
	}
	
	
}