package dataStructure.sort;

import java.util.Arrays;

/**
 * @author abaka
 * @date 2019/8/18 20:28
 */
public class QuickSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void qucikSort(int[] arr,int left,int right){
        int i = left;
        int j = right;
        if (i > j)
            return;
        int temp = arr[left];
        while (i < j){
            while (i < j && arr[j] >= temp){
                j--;
            }
            arr[i] =arr[j];
            while (i < j && arr[i] <= temp){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;
        qucikSort(arr,left,i - 1);
        qucikSort(arr,i + 1,right);
    }

    public static void main(String[] args) {
        int arr[] = {32,24,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
        qucikSort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
