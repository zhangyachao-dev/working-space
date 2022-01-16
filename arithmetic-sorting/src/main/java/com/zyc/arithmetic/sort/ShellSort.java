package com.zyc.arithmetic.sort;

/**
 * 希尔排序
 */
 public class ShellSort {
    public static void shellSort(int[] a){
        int length = a.length;
        for (int gap = length/2; gap > 0; gap /= 2){
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < length; j += gap){  //每个子序列都从第二个开始
                    if (a[j] < a[j - gap]){
                        int temp = a[j];
                        int k = j;
                        while ( k >= gap && a[k-gap] > temp){
                            a[k] = a[k-gap];
                            k -= gap;
                        }
                        a[k] = temp;
                    }
                }
            }
        }

    }
    public static void main(String[] args){
        int [] a = {9,2,5,3,10,1,4,8,0,7,6};
        shellSort(a);
        for (int anA : a) {
            System.out.print(anA + " ");
        }
    }
}