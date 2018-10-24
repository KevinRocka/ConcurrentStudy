
/**
 * @author: Rocka
 * @version: 1.0
 * @description: 线程的中断方法1
 * @time:2018/10/24
 */
public class ConcurrentStopThread {

    public static void main(String[] args) throws InterruptedException{
        ThreadRunner threadRunner = new ThreadRunner();
        Thread thread = new Thread(threadRunner);
        thread.start();
        //主线程休眠500毫秒让threadRunner来感知中断
        Thread.sleep(20);
        thread.interrupt();
    }

    public static class ThreadRunner implements Runnable{

        private long i = 0;

        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                i++;
                System.out.println("Thread 1 running output i:" + i);
            }
            System.out.println("Thread stop");
        }
    }
}
