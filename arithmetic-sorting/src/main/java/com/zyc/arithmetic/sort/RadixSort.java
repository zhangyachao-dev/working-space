package com.zyc.arithmetic.sort;

/**
 * 基数排序
 */
public class RadixSort {
    private static int getMax(int[] a ){
        int max = a[0];
        for (int i : a){
            if (i > max){
                max = i;
            }
        }
        return max;
    }
    private static void countSort(int[] a, int exp){
        int[] output = new int[a.length];
        int[] buckets = new int[10];
        for (int anA : a) {
            buckets[(anA / exp) % 10]++;
        }
        for (int i : buckets)
            System.out.print(i + " ");
        System.out.println();
        for (int i = 1; i < 10; i++){
            buckets[i] += buckets[i - 1];
        }
        for (int i : buckets)
            System.out.print(i + " ");
        System.out.println();
        for (int i = a.length - 1; i >= 0; i--){
            output[buckets[(a[i] / exp) % 10] - 1] = a[i];
            buckets[(a[i] / exp) % 10]--;
        }
        for (int i = 0; i < a.length; i++){
            a[i] = output[i];
        }
        output = null;
        buckets = null;
    }
    private static void radixSort(int[] a){
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10){
            countSort(a, exp);
        }
    }
    public static void main(String[] args){
        int[] a = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        radixSort(a);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}