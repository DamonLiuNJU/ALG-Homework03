package com.DamonLiu;

import java.util.Arrays;
import java.util.Random;

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

    public static int[] shellSort(int[] unsorted) {
        int group, i, j, temp;
        for (group = unsorted.length / 2; group > 0; group /= 2) {
            for (i = group; i < unsorted.length; i++) {
                for (j = i - group; j >= 0; j -= group) {
                    if (unsorted[j] > unsorted[j + group]) {
                        temp = unsorted[j];
                        unsorted[j] = unsorted[j + group];
                        unsorted[j + group] = temp;
                    }
                }
            }
        }
        return unsorted;
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
}
