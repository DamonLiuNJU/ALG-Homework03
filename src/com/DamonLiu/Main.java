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
        int[] capaticyList = {10,100,1000,10000,100000,1000000,10000000,100000000,200000000};
        long beginTime,endTime;
        int RepeatTime = 20;
        for (int i = 0; i < capaticyList.length; i++) {
            long totalTime = 0;
            for (int j = 0; j < RepeatTime; j++) {//每个容量算10次，取平均值。
                System.gc();
                int capacity = capaticyList[i];
                int[] array = generateRandomArrayWithCapacity(capacity);//the array used to sort
                beginTime= System.nanoTime();
//            int[] insertSortResult = Algorithms.insertionSort(array.clone());
//            int[] shell_SortResult = Algorithms.shellSort(array);
//                int[] quick_SortResult = Algorithms.quickSort(array,0,array.length-1);
//            int[] merge_SortResult = Algorithms.mergeSsort(array);
            int[] radix_SortResult = Algorithms.radixSort(array);
                endTime = System.nanoTime();
                totalTime += endTime - beginTime;
            }
            totalTime /= RepeatTime;
            System.out.println("Average Time : "+""+" = "+totalTime);
        }
    }

    

}
