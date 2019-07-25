package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author abaka
 * @date 2019/7/18 20:18
 */


class Goods{
    private String goodsName;

//    private String goodsCount;

    private int maxCount;

    private int count;
    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    private Lock lock = new ReentrantLock();
    private Condition consumer = lock.newCondition();
    private Condition producer = lock.newCondition();
    //生产
    public void setGoods(String name){
       lock.lock();
       try {
           while (this.count == maxCount){
               System.out.println(Thread.currentThread().getName() +
               "商品数量已经达到最大");
               producer.await();
           }
           Thread.sleep(200);
           this.count++;
           this.goodsName = name;
           System.out.println(Thread.currentThread().getName() +
           "生产一个" + toString());
            consumer.signalAll();
       }catch (InterruptedException e){
           e.printStackTrace();
       }finally {
            lock.unlock();
       }
    }

    //消费
    public void getGoods(){
        lock.lock();
        try {
            while (this.count == 0){
                System.out.println(Thread.currentThread().getName() +
                "没有商品了");
                consumer.await();
            }
            Thread.sleep(200);
            this.count--;
            System.out.println(Thread.currentThread().getName() +
            "消费一个" + toString());
            producer.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return "MultiThread.Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}


class Producer implements Runnable{

    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    public void run() {
        while (true){
            goods.setGoods("冰红茶");
        }
    }
}

class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    public void run() {
        while (true){
            goods.getGoods();
        }
    }
}

public class ProcucerConsumer {
    public static void main(String[] args) {
        Goods goods = new Goods(10);
        Producer producer = new Producer(goods);
        Consumer consumer = new Consumer(goods);
        List<Thread> list = new ArrayList<Thread>();

        for (int i = 0; i < 10; i++){
            Thread thread = new Thread(producer);
            list.add(thread);
        }

        for (int i = 0; i < 6; i++){
            Thread thread = new Thread(consumer);
            list.add(thread);
        }

        for (Thread t: list){
            t.start();
        }
    }
}
