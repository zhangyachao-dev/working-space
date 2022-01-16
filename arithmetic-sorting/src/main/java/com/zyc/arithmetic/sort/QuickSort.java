package com.zyc.arithmetic.sort;

/**
 * 快速排序
 */
public class QuickSort {
    
    private static void quickSort(int [] a, int low, int high){
        if (low >= high){
            return;
        }
        int i = low;
        int j = high;
        int temp = a[i];
        while (i < j){
            while (i <j && a[j] >= temp){
                j--;
            }
            if (i < j){
                a[i++] = a[j];
            }
            while (i < j && a[i] < temp){
                i++;
            }
            if (i < j){
                a[j--] = a[i];
            }
        }
        a[i] = temp;
        quickSort(a, low, i -1);
        quickSort(a, i + 1, high);
    }

    public static void main(String [] args){
        int [] a = {9,2,5,3,1,4,8,0,7,6};
        quickSort(a, 0, a.length-1);
        for (int anA : a) {
            System.out.print(anA + " ");
        }
    }
}