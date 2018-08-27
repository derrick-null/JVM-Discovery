package com.derrick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Derrick on 2018-08-23.
 * ArrayList Sample
 */
public class ArrayListSample {

    /**
     * ArrayList的subList方法返回的是ArrayList内部的一个子类
     * 强行转成ArrayLisr的话会引起ClassCastException java.util.RandomAccessSubList cannot be cast to java.util.ArrayLis
     * 修改sublist的内容会引起原始List内容的变化
     * */
    private void sublistSample(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //Cause ClassCastException
        //ArrayList sublist = (ArrayList) list.subList(1, 2);
        List<String> sublist = list.subList(1, 2);
        sublist.add("4");
        System.out.println(sublist);
        //subList会改变原来的List
        System.out.println(list);
    }
    /**
     * 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全
     一样的数组，大小就是 list.size()。
     使用 toArray 带参方法，入参分配的数组空间不够大时，toArray 方法内部将重新分配
     内存空间，并返回新数组地址；如果数组元素个数大于实际所需，下标为[ list.size() ]
     的数组元素将被置为 null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集
     合元素个数一致。
     * */
    private void toArraySample(){
        List<String> list = new ArrayList<String>(3);
        list.add("1");
        list.add("2");
        list.add("3");
        //bad practice
        //String[] array = new String[]{};
        //good practice
        String[] array = new String[list.size()];
        //必须使用有参的toArray，无参的会引起ClassCastException
        array = list.toArray(array);
        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方
     法，它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
     asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList
     体现的是适配器模式，只是转换接口，后台的数据仍是数组。
     * */
    private void asListSample(){
        String[] array = {"1","2","3"};
        List list = Arrays.asList(array);
        //Cause java.lang.UnsupportedOperationException
        //list.add("4");
        //list内容也会变化
        array[0] = "first";
        System.out.println(list);

    }
    /**
     * 不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
     方式，如果并发操作，需要对 Iterator 对象加锁。
     * */
    private void operationSample(){
        //泛型
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        //bad practice
        /*while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.equals("1")) {
                iterator.remove();
            }
        }*/
        //如果不是第一个元素进行判断会引起java.util.ConcurrentModificationException
        for (String item : list) {
            //1的话执行正常
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }
    /**
     *数组初始化
     * */
    private void initSample(){
        long begin = System.currentTimeMillis();
        System.out.println("指定大小begin:" + begin);
        List<String> list = new ArrayList<>(10000000);
        for (int i=0; i<10000000; i++){
            list.add("str");
        }
        long end = System.currentTimeMillis();
        System.out.println("指定大小end:" + end);
        long cost = end - begin;
        System.out.println("指定大小cost:" + cost);

        long begin2 = System.currentTimeMillis();
        System.out.println("不指定大小begin:" + begin2);
        List<String> list2 = new ArrayList<>();
        for (int i=0; i<10000000; i++){
            list2.add("str");
        }
        long end2 = System.currentTimeMillis();
        System.out.println("不指定大小end:" + end2);
        long cost2 = end2 - begin2;
        System.out.println("不指定大小cost:" + cost2);
    }

    public static void main(String[] args){
        ArrayListSample sample = new ArrayListSample();
        sample.toArraySample();
        //sample.sublistSample();
        //sample.asListSample();
        //sample.operationSample();
        //sample.initSample();
    }
}
