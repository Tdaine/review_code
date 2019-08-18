package dataStructure.sort;

import java.util.Arrays;

/**
 * @author abaka
 * @date 2019/8/18 17:34
 */
public class SelectSort {

    public static void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void selectSort(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        int min = 0;
        int max = arr.length - 1;
        while (left < right){
            for (int i = left; i <= right; i++){
                if (arr[i] < arr[min])
                    min = i;
                if (arr[i] > arr[max])
                    max = i;
            }
            if (min != left){
                swap(arr,min,left);
            }
            if (max != right && max != left){
                swap(arr,max,right);
            }else if (max == left){
                swap(arr,min,right);
            }
            left++;
            right--;
            min = left;
            max = right;
        }
    }

    public static void main(String[] args) {
        int arr[] = {32,24,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
