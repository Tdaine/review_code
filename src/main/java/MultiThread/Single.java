package MultiThread;

/**
 * @author abaka
 * @date 2019/7/30 17:01
 */
public class Single {
    private volatile static Single single = null;

    private Single() { }

    public static Single getInstance(){

        if (single == null){
            synchronized (Single.class){
                if (single == null){
                    single = new Single();
                }
            }
        }
        return single;
    }
}
