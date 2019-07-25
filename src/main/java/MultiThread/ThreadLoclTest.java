package MultiThread;

/**
 * @author abaka
 * @date 2019/7/25 15:57
 */
public class ThreadLoclTest {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<String>();

    public static void main(String[] args) {
        commStr = "main";
        threadStr.set("main");

        final Thread thread = new Thread(new Runnable() {
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);//thread
        System.out.println(threadStr.get());//main  可以看出threadLoca类型的变量，在一个线程中设置值，不影响其他线程中的值。所以threadLocal类型的变量值在每个线程都是独立的
    }
}
