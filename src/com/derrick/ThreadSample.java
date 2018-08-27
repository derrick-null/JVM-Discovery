package com.derrick;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Derrick on 2018-08-17.
 * 线程测试
 */
public class ThreadSample {
    private static Object s = new Object();
    private static int count = 0;
    public static void main(String[] argv){
        while(true){
            new Thread(new Runnable(){
                @Override
                public void run(){
                    synchronized(s){
                        count += 1;
                        System.err.println("New thread #"+count);
                    }
                    for(;;){
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e){
                            System.err.println(e);
                        }
                    }
                }
            },"ThreadSample"+count).start();//一定要指定线程的名字，帮助排除问题
        }
    }

    private void PoolSample(){
        //pool的持有数量
        int corePoolSize = 10;
        //pool的最大数量
        int maxPoolSize = 20;
        //当pool的数量大于corePoolSize时，线程的最大存活时间
        long keepAliveTime = 10000L;
        //存活时间的单位
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue queue = new LinkedBlockingQueue();
        //使用ThreadPoolExecutor创建线程池，不要自己new thread或者使用Executors
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,maxPoolSize,keepAliveTime,unit,queue);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //do something
            }
        });
    }
}
