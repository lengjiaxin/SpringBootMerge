package www.coolcat.club;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName AppTest
 * @Description i++ 线程安全处理   volatile  CAS
 * @Author Lengjx
 * @Date 2018-09-21 10:18
 * @Version 1.0
 **/
public class AtomicIntegerTest {

    static AtomicInteger count = new AtomicInteger();//volatile  CAS
    static CountDownLatch cdl = new CountDownLatch(2000);//实现多个线程开始执行任务的最大并行性。注意是并行性

    public static void main(String[] args) throws Exception {

        CountRunnable countRunnable = new CountRunnable();
        for (int i = 0; i < 1000; i++) {
            new Thread(countRunnable).start();
            new Thread1().start();
        }
        cdl.await();
        System.out.println(count);
    }


    static class CountRunnable implements Runnable {
        private void count() {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        }
        @Override
        public void run() {
            count();
            cdl.countDown();
        }

    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
            cdl.countDown();
        }
    }

}
