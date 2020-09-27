package demo01;


import com.lmax.disruptor.EventHandler;

/**
 * @program: leetcode
 * @description:
 * @author: HuRan
 * @create: 2020-09-26 12:54
 */
public class DataConsumer implements EventHandler<Data> {
    private long startTime;
    private  int i;
    public DataConsumer(){
        this.startTime=System.currentTimeMillis();
    }
    public void onEvent(Data data, long l, boolean b) throws Exception {
        i++;
        if(i==Constant.EVENT_NUM_OHM){
            long endTime=System.currentTimeMillis();
            System.out.println(endTime - startTime+" ms");
        }
    }
}