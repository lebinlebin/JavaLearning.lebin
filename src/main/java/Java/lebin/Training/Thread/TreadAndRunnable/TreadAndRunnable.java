package Java.lebin.Training.Thread.TreadAndRunnable;

/**
 * Java多线程之Thread与Runnable
 * 一、Thread VS Runnable
 * 　　在java中可有两种方式实现多线程，一种是继承Thread类，一种是实现Runnable接口；
 * Thread类和Runnable接口都是在java.lang包中定义的。
 * 接下来本文给大家介绍下Java中Runnable和Thread的区别，
 *
 * 实现Runnable接口方式可以避免继承Thread方式由于Java单继承特性带来的缺陷。具体什么缺陷呢？
 * 　　①首先来从接口实现和类继承的区别来谈谈
 * 　　如果你想写一个类C，但这个类C已经继承了一个类A，此时，你又想让C实现多线程。用继承Thread类的方式不行了。
 * （因为单继承的局限性），此时，只能用Runnable接口，Runnable接口就是为了解决这种情境出现的
 *
 * 　　②从Thread和Runnable的实现机制再来谈谈这个问题
 *
 * 　　首先 Thread 和 Runnable 实际上是一种静态代理的实现方式。我们可以简单看一下源代码就了解了：
 *JAVA多线程
 *
 * 到目前为止，线程都是通过扩展Thread类来创建的，如果程序员需要继承其他类（非Thread类），
 * 而且还要使用当前类实现多线程，那么可以通过Runnable接口来进行实现。
 *
 *
 * 具体语法是：
 *
 * public class Thread extends Object implements Runnable
 *
 * 使用Runnable 接口 启动新的线程的步骤如下：
 * 1。 建立Runnable 对象
 * 2。使用参数为Runnable 对象的构造方法进行创建Thread 实例
 * 3。调用start()方法启动线程
 *
 * Runnable
 * 接口应该是有哪些打算通过某一个线程执行其中实例的类进行实现，类必须定义一个称为run的无参方法。
 *
 * Thread (Runnable target)
 *
 * 创建线程第二种方式
 * 实现Runnable 接口
 * 1.定义类实现Runnable 接口
 * 2. 覆盖Runnable 接口中的run方法
 * （将线程要运行的代码存放在该run方法中）
 * 3. 通过Thread 类建立线程对象
 * 4.将Runnale接口的子类对象作为实际的参数传递给Thread 类的构造函数
 * （为什么要Runnable 接口的自欸对象传递给Thread的子类对象，所以要让线程去指定对象的run方法，就必须明确该run方法所属的对象）
 * 5.调用Thread 类的start方法开启线程并且调用Runnable 接口的子类的run 方法。
 */

/**
 * 此应用程序公共类有一个double型类属性（变量）x，初始值为0；
 * 在应用程序主进程中新开两个线程，这两个线程都进行死循环；
 * 第1个线程每隔300ms激活一次，令类属性x自加1.0并输出显示；
 * 第2个线程每隔400ms激活一次，令类属性x自加0.1并输出显示。
 */
public class TreadAndRunnable {

    //定义一个浮点型变量并赋值
    static double x=0;

    public static void main(String[] args){
        //创建一个新的线程
        Thread a = new Thread(new ACThread());
        //创建一个新的线程
        Thread b = new Thread(new BCThread());

        //显示x初值是0
        System.out.println("初值："+x);
        a.start();
        b.start();
    }
    public static class ACThread implements Runnable{
        @Override
        public void run(){
            try{
                while(true){
                    Thread.sleep(300);
                    x+=1;
                    System.out.println("线程1="+x);
                }
            }
            catch(InterruptedException e){
            }
        }
    }
    public static class BCThread implements Runnable{
        @Override
        public void run(){
            try{
                while(true){
                    Thread.sleep(400);
                    x+=0.1;
                    System.out.println("线程2="+x);
                }
            }
            catch(InterruptedException e){
            }
        }
    }
}