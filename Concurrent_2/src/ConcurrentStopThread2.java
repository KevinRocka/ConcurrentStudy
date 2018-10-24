/**
 * @author: Rocka
 * @version: 1.0
 * @description: 线程的中断方法2
 * @time:2018/10/23
 */
public class ConcurrentStopThread2 {

    public static void main(String[] args) throws InterruptedException{
        ThreadRunner threadRunner = new ThreadRunner();
        Thread stropThread = new Thread(threadRunner);
        stropThread.start();
        Thread.sleep(20);
        threadRunner.exit();

    }

    public static class ThreadRunner implements Runnable{

        private long i = 0;

        //所有线程都会被通知到这个变量的变化
        private volatile boolean on = true;

        public void run() {
            while (on){
                i++;
                System.out.println("Thread 2 running output i:" + i);
            }
            System.out.println("Thread stop");
        }

        public void exit(){
            on = false;
        }
    }
}
