package interviews;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/11 19:41
 */
public class toutiao2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        if (s2.equals("") || s1.equals("") || s1 == null || s2 == null || s2.length() > s1.length())
            System.out.println("False");
        ArrayList<char[]> arrayList = new ArrayList<char[]>();
        char[] sArr = s2.toCharArray();
        order(sArr,0,sArr.length,arrayList);

        for (char[] arr : arrayList){
            String s = new String(arr);
            if (s1.contains(s)){
                System.out.println("True");
                return;
            }
        }
        System.out.println("False");
    }

    public static void order(char[] arr,int start,int n,ArrayList result){
        if (start == n)
            return;
        if (start == n - 1){
            char[] temp = arr.clone();
            result.add(temp);
            return;
        }

        for (int i = start; i < n; i++){
            swap(arr,start,i);
            order(arr,start + 1,n,result);
             swap(arr,start,i);
        }
    }

    public static void swap(char[] arr,int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
