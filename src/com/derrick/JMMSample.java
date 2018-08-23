package com.derrick;

/**
 * Created by Derrick on 2018-08-14.
 * JMM Sample Code
 */
public class JMMSample {
    private int a = 0;
    //??volatile??????????????????
    //private volatile boolean flag = false;
    //???volatile????????????????????
    private boolean flag = false;

    public void write() {
        a = 1;
        flag = true;
    }

    public void read() {
        if (flag) {
            int i = a;
            System.out.println("i=" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final JMMSample volatileDemo = new JMMSample();
        Thread write = new Thread(new Runnable() {
            public void run() {
                volatileDemo.write();
            }
        });

        Thread read = new Thread(new Runnable() {
            public void run() {
                volatileDemo.read();
            }
        });

        write.start();
        read.start();
        write.join();
        read.join();
    }
}
