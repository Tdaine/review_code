package dataStructure.sort;

import java.util.Arrays;

/**
 * @author abaka
 * @date 2019/7/25 18:43
 */

public class ShellSort {

    private static int[] shell(int[] arr){
        int gap = arr.length / 2;
        while (gap >= 1){
            for (int i = gap; i < arr.length; i++){
                int x = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > x){
                    arr[j + gap] = arr[j];
                    j = j - gap;
                }
                arr[j + gap] = x;
            }
            System.out.println(Arrays.toString(arr));
            gap = gap / 2;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {32,24,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
        arr = shell(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
