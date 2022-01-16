package com.zyc.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private static void bubbleSort(int [] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = n -1; j > i; j--){
                if (a[j-1] > a[j]){
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static void main(String [] args){
        int [] a = {9,2,5,3,1,4,8,0,7,6};
        bubbleSort(a);
        for (int anA : a) {
            System.out.print(anA + " ");
        }
    }
}