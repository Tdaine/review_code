package dataStructure.sort;

import java.util.Arrays;

/**
 * @author abaka
 * @date 2019/8/18 17:21
 */
public class InsertSort {

    private static void insertSoet(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = 0;
            for (j = i; j > 0; j--){
                if (arr[j - 1] > temp){
                    arr[j] = arr[j - 1];
                }else {
                    break;
                }
            }
            if (j != i)
                arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {32,24,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
        insertSoet(arr);
        System.out.println(Arrays.toString(arr));
    }
}
