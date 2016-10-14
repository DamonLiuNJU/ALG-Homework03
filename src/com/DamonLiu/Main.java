package com.DamonLiu;

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
        int[] capaticyList = {10,100,1000,10000,100000,1000000,10000000,100000000,200000000,1000000000};
        for (int i = 0; i < capaticyList.length; i++) {
            int capacity = capaticyList[i];
            int[] array = generateRandomArrayWithCapacity(capacity);//the array used to sort
            int[] insertSortResult = Algorithms.insertionSort(array.clone());
            int[] shell_SortResult = Algorithms.shellSort(array.clone());
            int[] quick_SortResult = Algorithms.quickSort(array.clone(),0,array.length-1);
            int[] merge_SortResult = Algorithms.mergeSsort(array.clone());

            System.out.println("?");
//            for (int j = 0; j < array.length; j++) {
//                System.out.print(array[j]+" ");
//            }
//            System.out.println();
            System.currentTimeMillis();
        }
    }

    
    public static int[] radixSort(int [] input){



        return input;
    }
}
