package com.derrick;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Derrick on 2018-04-26.
 * 堆内存溢出
 */
public class HeapOOMMain {

    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread OOM
        // -Xms30m -Xmx30m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:/jvm.out.dump
        List<ThreadOOMObj> list = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        while(true){
            list.add(new ThreadOOMObj());
            strings.add("test"+System.currentTimeMillis());
        }
    }

}

class ThreadOOMObj{

}


