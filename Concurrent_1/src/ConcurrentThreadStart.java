import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: Rocka
 * @version: 1.0
 * @description: 启动线程的第三种方式(callable接口)
 * @time:2018/10/23
 */
public class ConcurrentThreadStart {

    //这是个线程类
    public static class MyTestCallable implements Callable<String>{
        public String call() throws Exception {
            return "Callable HelloWord";
        }
    }

    public static void main(String[] args){
        System.out.println("Hello Start");
        MyTestCallable myTestCallable = new MyTestCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future mFuture = executorService.submit(myTestCallable);
        try {
            System.out.println("得到线程返回结果:" + mFuture.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
