package com.zyc.arithmetic.sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void merge(int [] a, int start, int median, int end){
        int i;
        int j;
        int k;
        int n1 = median - start + 1;
        int n2 = end - median;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (i = 0, k = start; i < n1; i++, k++){
            L[i] = a[k];
        }
        for (i = 0, k = median + 1; i < n2; i++, k++){
            R[i] = a[k];
        }
        for (k = start, i = 0, j = 0; i < n1 && j < n2; k++){
            if (L[i] < R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
        }
        while (i < n1){
            a[k] = L[i];
            i++;
            k++;
        }
        while (j < n2){
            a[k] = R[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] a, int start, int end){
        if (start < end){
            int median = (start + end) / 2;
            mergeSort(a, start, median);
            mergeSort(a, median + 1, end);
            merge(a, start, median, end);
        }
    }

    public static void main(String[] args){
        int [] a = {9,2,5,3,10,1,4,8,0,7,6};
        mergeSort(a, 0, a.length-1);
        for (int anA : a) {
            System.out.print(anA + " ");
        }
    }
}