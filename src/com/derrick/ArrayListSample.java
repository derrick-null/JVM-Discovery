package com.derrick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Derrick on 2018-08-23.
 * ArrayList Sample
 */
public class ArrayListSample {

    /**
     * ArrayList?subList???????ArrayList??????ClassCastException
     * ???? java.util.RandomAccessSubList cannot be cast to java.util.ArrayList?
     * ???subList ???? ArrayList ???? SubList???? ArrayList ?? ArrayList
     * ???????? SubList ??????????????????
     * */
    private void sublistSample(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        //Cause ClassCastException
        //ArrayList sublist = (ArrayList) list.subList(1, 2);
        List sublist = list.subList(1, 2);
        sublist.add("4");
        System.out.println(sublist);
        //subList?????????List
        System.out.println(list);
    }

    private void toArraySample(){
        List<String> list = new ArrayList<String>(3);
        list.add("1");
        list.add("2");
        list.add("3");
        String[] array = new String[]{};
        //????toArray????????????????Cause ClassCastException
        array = list.toArray(array);
        for (int i=0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }



    public static void main(String[] args){
        ArrayListSample sample = new ArrayListSample();
        sample.toArraySample();
    }
}
