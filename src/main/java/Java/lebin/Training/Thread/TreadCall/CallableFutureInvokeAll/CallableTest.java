package Java.lebin.Training.Thread.TreadCall.CallableFutureInvokeAll;


import java.util.concurrent.Callable;

/**
 * 线程类：
 * 类名称:CallableTest.java
 * 类描述:
 */
public class CallableTest implements Callable<String> {
    //接收传来的值
    private String str;
    public CallableTest(String str){
        super();
        this.str = str;
    }
    @Override
    public String call() throws Exception {
        //要执行的耗时操作,为了体验效果，每调用一次，休眠1000ms
        Thread.sleep(1000);
        return str;
    }
}