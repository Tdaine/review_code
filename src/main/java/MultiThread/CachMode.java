package MultiThread;

/**
 * @author abaka
 * @date 2019/8/17 10:26
 */

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用HashMap和ReentrantReadWriteLock实现缓存
 */

public class CachMode {
    private HashMap<String,Object> cach = new HashMap<String, Object>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public Object getData(String key){
        Object value = null;
        try {
            lock.readLock().lock();//获取线程的读锁
            value = cach.get(key);//从缓存中获取值
            if (value == null){//缓存中的值为null，需要先向缓存中写入数据
               try {
                   lock.readLock().unlock();//释放读锁
                   lock.writeLock().lock();//获取写锁
                   if (value == null){//防止多线程情况下多个写锁阻塞在这里，
                       //被唤醒后的value不为null，当另外一个线程也被唤醒如果不判断就会执行
                       value = "写入1";
                       cach.put(key,value);
                   }
                   lock.readLock().lock();//写完之后重新降级为读锁
               }finally {
                   lock.writeLock().unlock();//释放写锁
               }
            }
        }finally {
            lock.readLock().unlock();//释放读锁
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
