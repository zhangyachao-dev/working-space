package com.zyc.arithmetic.sort;

/**
 * 选择排序
 */
public class SelectSort {
    private static void sortSelect(int [] a ){
        int i;
        int j;
        int temp = 0;
        int flag = 0;
        for (i = 0; i < a.length; i++){
            temp = a[i];
            flag = i;
            for (j = i +1; j <a.length; j++){
                if (a[j] < temp){
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i){
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }
    public static void main(String [] args){
        int [] a = {3,1,5,4,2,7,8,6,0,9};
        sortSelect(a);
        for (int i = 0; i < a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}