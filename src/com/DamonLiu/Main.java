package com.DamonLiu;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Random;

public class Main {

    static int bound = (int)Math.pow(2,23)-1;

    public static int[] generateRandomArrayWithCapacity(int capacity){
        int[] result = new int[capacity];
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            result[i] = random.nextInt(bound);
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        //10, 102, 103, 104, 105, 106, 107, 108, 2 × 108
        int i23=1000;
        System.out.println("1000的二进制表示：\t"+Integer.toBinaryString(i23));
//        int[] capaticyList = {1000000000};
        int[] capaticyList = {10,100,1000,10000,100000,1000000,10000000,100000000,200000000,};
        int[] tryTime =      {200,200, 200,  200,   100,    20,     20,      20,       10,};
        long beginTime,endTime;

        for (int i = 0; i < capaticyList.length; i++) {
            long totalTime = 0;
            int RepeatTime = tryTime[i];
            for (int j = 0; j < RepeatTime; j++) {//每个容量算10次，取平均值。
//                System.gc();
                int capacity = capaticyList[i];
                int[] array = generateRandomArrayWithCapacity(capacity);//the array used to sort
//                String[] array_String = new String[array.length];
//                for (int k = 0; k < array.length; k++) {
//                    array_String[k] = padLeft(Integer.toBinaryString(array[k]),32,'0');
//                }
                //
//                beginTime= System.nanoTime();
//                Algorithms.shellSort(array);
//                endTime = System.nanoTime();
//                System.out.println("Shell : " + (endTime - beginTime));

//                beginTime= System.nanoTime();
//                Algorithms.quickSort(array,0,array.length-1);
//                endTime = System.nanoTime();
//                System.out.println("Quick : " + (endTime - beginTime));

                beginTime= System.nanoTime();
                Algorithms.enhancedRadixSort(array);
                endTime = System.nanoTime();
//                System.out.println("Enhanced Radix : " + (endTime - beginTime));

//                beginTime= System.nanoTime();
//                Algorithms.mergeSsort(array);
//                endTime = System.nanoTime();
//                System.out.println("Merge : " + (endTime - beginTime));

//                beginTime= System.nanoTime();
//                int tmp = (int)Math.pow(2,32);
//                int length = (tmp+"").length();
//                Algorithms.radixSort(array,10,length);
//                endTime = System.nanoTime();
//                System.out.println("Radix : " + (endTime - beginTime));


//            int[] insertSortResult = Algorithms.insertionSort(array.clone());
//            int[] shell_SortResult = Algorithms.shellSort(array);
//                int[] quick_SortResult = Algorithms.quickSort(array,0,array.length-1);
//            int[] merge_SortResult = Algorithms.mergeSsort(array);
//            int[] radix_SortResult = Algorithms.radixSort(array);
//                int tmp = (int)Math.pow(2,32);
//                int length = (tmp+"").length();
//                Algorithms.radixSort(array,10,length);

                totalTime += endTime - beginTime;
            }
            totalTime /= RepeatTime;
            System.out.println("Average Time : "+""+" = "+totalTime);
        }
    }

    /**
     * 左补位，右对齐
     * @param oriStr  原字符串
     * @param len  目标字符串长度
     * @param alexin  补位字符
     * @return  目标字符串
     */
    public static String padLeft(String oriStr,int len,char alexin){
        int strlen = oriStr.length();
        String str = "";
        if(strlen < len){
            for(int i=0;i<len-strlen;i++){
                str = str+alexin;
            }
        }
        str = str + oriStr;
        return str;
    }

    

}
