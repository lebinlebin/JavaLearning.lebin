package Java.lebin.Training.ObjectOriented.day11staticAndSingleton.demo1EqualsFinalizeToString;
/**
 * 
 *此类用于演示Object类的常见方法：finalize
 *
 *一、自动垃圾回收机制
 *原理：当应用已启动，实际上相当于开起了 主线程main和垃圾回收器线程
 *垃圾回收器将默默检测是否有需要回收的对象，一旦有了，则需要回收该对象以释放空间供其他有用对象使用，该对象被回收时同时调用finalize方法
 *
 *1、回收哪些对象？
 *答：无用对象（没有任何引用指向的对象）
 *
 *2、回收的时机？
 *答：不确定的
 *
 *3、如何加速垃圾回收器的回收？
 *
 *答：唤醒垃圾回收器
 *System.gc();
 *
 *4、finalize方法什么时候被调用？
 *只要被回收，肯定被调用
 *
 *
 */
public class TestFinalize {
	
	public static void main(String[] args) {
		Animal a = new Animal();
		
		a=null;
		System.gc();
		
		
		int i=1;
		i++;
		++i;
		i+=9;
		
		
		
	}

}
class Animal{
	/**
	 * 功能：清除资源的工作
	 */
	@Override
	public void finalize() throws Throwable {
		
		System.out.println("我被回收了，号可怜啊，┭┮﹏┭┮");
		
	}
	
}











