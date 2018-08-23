package com.derrick;

/**
 * Created by Derrick on 2018-04-26.
 * stackOverFlowError??????????????????
 */
public class StackSOFMain {

    public static void main(String arg[]){
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //VM stack SOF
        // -Xms20m -Xmx20m -Xss128k
        SOFObj sofObj = new SOFObj();
        try{
            sofObj.stackSOF();
        } catch(Exception e){
            System.out.println(sofObj.str);
        }
    }
}
class SOFObj{

    public String str = "test";

    public void stackSOF(){
        str += "1";
        System.out.println(str);
        stackSOF();
    }

}