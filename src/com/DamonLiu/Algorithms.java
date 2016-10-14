package com.DamonLiu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

/**
 * Created by DamonLiu on 2016/10/13.
 */
public class Algorithms {
    public static int[] insertionSort(int[] input) {
        int n = input.length;
        int x = 0;
        for (int i = 1; i < n; ++i) {
            x = input[i];
            int j = i - 1;
            while (j >= 0 && input[j] > x) {
                input[j + 1] = input[j];
                j--;
            }
            input[j + 1] = x;
        }
        return input;
    }

    public static int[] shellSort(int[] input) {
        int group, i;
        for (group = input.length / 2; group > 0; group /= 2) {//从n/2开始进行排序
            for (i = group; i < input.length; i++) { //use insert sort.
                int x = input[i];
                int j = i - group;
                while (j >= 0 && input[j] > x) {
                    input[j + group] = input[j];
                    j -= group;
                }
                input[j + group] = x;
            }
        }
        return input;
    }

    public static int[] quickSort(int n[], int left, int right) {
        int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quickSort(n, left, dp - 1);
            quickSort(n, dp + 1, right);
        }
        return n;
    }

    private static int partition(int n[], int left, int right) {
        int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
    }

    private static void mergeSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mergeSortRecursive(arr, result, start1, end1);
        mergeSortRecursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static int[] mergeSsort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        mergeSortRecursive(arr, result, 0, len - 1);
        return result;
    }


    /**
     * 基数排序
     *
     * @param
     * @return
     */
    public static int[] radixSort(int[] number) {
        int max = -1;
        for (int i = 0; i < number.length; i++) {
            max = number[i] > max ? number[i] : max;
        }
        int d = (max + "").length();
        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
//        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        ArrayList<Vector<Integer>> temp = new ArrayList<>(10);
        
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
//                temp[lsd][order[lsd]] = number[i];
                Vector<Integer> vector = temp.get(lsd);
                vector.add(number[i]);
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp.get(i).get(j);
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
        return number;
    }

    /**
     * 普通计数排序
     *
     * @param input 整数数组
     * @return 排序结果
     */
    private static int[] countSort(int[] input, int upperRange) {
        int[] result = new int[input.length];
        int[] counter = new int[upperRange];

        return input;
    }


}
