package com.zyc.arithmetic.sort;

/**
 * 堆排序
 */
public class HeapSort {
    private static void maxHeapDown(int[] a, int start, int end){
        int father = start;
        int child = 2 * father + 1; // 左孩子
        while (child <= end){
            if (child < end && a[child] < a[child + 1]){
                child++;  // 如果右孩子大，将左孩子变为右孩子
            }
            if (a[father] >= a[child]){
                break;
            }else {
                int tmp = a[father];
                a[father] = a[child];
                a[child] = tmp;
            }
            father = child;
            child = 2 * father + 1;
        }
    }
    private static void heapSortAsc(int[] a){
        int i;
        int n = a.length;
        for (i = n / 2 -1; i >= 0; i--){  // 从最后一个非终端节点开始，逐个向上遍历
            maxHeapDown(a, i, n-1);
        }
        for (i = n - 1; i > 0; i--){
            int tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            maxHeapDown(a, 0, i-1);
        }
    }
    public static void main(String[] args){
        int[] a = {9,2,5,4,7,3,8,0,1,6};
        heapSortAsc(a);
        for (int i :a){
            System.out.print(i + " ");
        }
    }
}