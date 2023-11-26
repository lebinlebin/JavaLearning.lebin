package Java.lebin.Training.Thread.TreadCall.CallableFutureInvokeAll;


import java.util.ArrayList;
import java.util.List;
/**
 * JUC
 */
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**调用类：
 * 类名称:RunTest.java
 * 类描述:
 */
public class RunTest {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService ex = Executors.newCachedThreadPool();


        List<CallableTest> taskList = new ArrayList<CallableTest>();
        //CallableTest 线程处理实体 这里即是：Runnable实例或Callable实例；
        long now = System.currentTimeMillis();
        taskList.add(new CallableTest("1"));
        taskList.add(new CallableTest("2"));
        taskList.add(new CallableTest("3"));
        taskList.add(new CallableTest("4"));
        try {
            //调用线程，并且接收线程返回的结果
            List<Future<String>> as = ex.invokeAll(taskList);
            for(Future<String> f:as){
                //打印返回结果
                System.out.println(f.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("currentTimeMillis: ");
        System.out.println((System.currentTimeMillis()-now));
    }
}
