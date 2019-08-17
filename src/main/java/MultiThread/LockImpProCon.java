package MultiThread;

/**
 * @author abaka
 * @date 2019/8/17 11:25
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用Lock + condition实现生产者消费者模型
 */
class Foods{
    //商品名称
    private String name;
    //当前商品数量
    private int count;
    //商品最大数量
    private int maxCount;

    public Foods(int maxCount){
        this.maxCount = maxCount;
    }

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();

    /**
     * 生产方法
     */
    public void proFoods(String name){
        lock.lock();
        try {
            while (this.count == maxCount){
                System.out.println(Thread.currentThread().getName()
                + "商品数量已经达到最大，等待消费者线程");
                producer.await();
            }
            Thread.sleep(200);
            this.count++;
            this.name = name;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            consumer.signalAll();
        }catch (InterruptedException e){
            System.out.println("生产出现问题");
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void conFoods(){
        lock.lock();
        try {
            while (this.count == 0){
                System.out.println(Thread.currentThread().getName() +
                "商品没有了，等待生产者");
                consumer.await();
            }
            Thread.sleep(200);
            this.count--;
            System.out.println(Thread.currentThread().getName() +
            "消费一个" + toString());
            producer.signalAll();
        }catch (InterruptedException e){
            System.out.println("消费者出现问题");
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "Foods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}

class Producer implements Runnable{
    private Foods foods;

    public Producer(Foods foods) {
        this.foods = foods;
    }

    public void run() {
        while (true){
            this.foods.proFoods("一份麻辣拌");
        }
    }
}

class Consumer implements Runnable{
    private Foods foods;

    public Consumer(Foods foods) {
        this.foods = foods;
    }

    public void run() {
        while (true){
            this.foods.conFoods();
        }
    }
}

public class LockImpProCon {
    public static void main(String[] args) {
        List<Thread> list = new ArrayList<Thread>();
        Foods foods = new Foods(10);
        Producer producer = new Producer(foods);
        Consumer consumer = new Consumer(foods);
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(consumer,"消费者" + i);
            list.add(thread);
        }
        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(producer,"生产者" + i);
            list.add(thread);
        }

        for (Thread l:list) {
            l.start();
        }
    }
}
