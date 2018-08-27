package com.derrick;

/**
 * Created by Derrick on 2018-04-26.
 * visualVM查看线程状态
 */
public class ThreadMain {
    public static void main(String[] args){
        threadBusySample();
        Object obj = new Object();
        threadWaitLock(obj);
    }

    public static void threadBusySample(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        },"threadBusySample");
        thread.start();
    }

    public static void threadWaitLock(final Object obj){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        obj.wait(200000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"threadWaitLock");
        thread.start();
    }
}
