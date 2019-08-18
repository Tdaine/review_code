package dataStructure.sort;

import java.util.Arrays;

/**
 * @author abaka
 * @date 2019/8/18 16:55
 */
public class MergeSort {

    private static void mergeSort(int[] arr,int start,int end){
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        mergeSort(arr,start1,end1);
        mergeSort(arr,start2,end2);
        mergeSort(arr,start1,end1,start2,end2);
    }

    private static void mergeSort(int[] arr,int start1,int end1,int start2,int end2){
        if (arr[end1] <= arr[start2])
            return;
        int[] temp = new int[end2 - start1 + 1];
        int i = 0;
        int start = start1;
        while (start1 <= end1 && start2 <= end2){
            if (arr[start1] <= arr[start2])
                temp[i++] = arr[start1++];
            else{
                temp[i++] = arr[start2++];
            }
        }

        while (start1 <= end1)
            temp[i++] = arr[start1++];
        while (start2 <= end2)
            temp[i++] = arr[start2++];
        for (int j = 0; j < temp.length; j++){
            arr[j + start] = temp[j];
        }
    }

    public static void main(String[] args) {
        int arr[] = {32,24,95,45,75,22,95,49,3,76,56,11,37,58,44,19,81};
        mergeSort(arr,0,arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        for (int i:arr
             ) {
            System.out.print(i + " ");
        }
    }
}
