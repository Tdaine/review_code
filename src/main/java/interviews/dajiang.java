package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/6 19:36
 */
public class dajiang {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        StringBuilder sb = new StringBuilder();
        int flage = 0;
        for (int i = s.length() - 1; i >= 0; i-=4){
            String s1;
            if (i + 4 < s.length()){
                s1 = s.substring(i,i + 4);
                sb.insert(0,change(s1));
                flage++;
            }else {
                s1 = s.substring(i);
                sb.insert(0,change(s1));
            }
            sb.append(change(s1));
            if (flage == 1){
                sb.insert(0,"万");
            }else if (flage == 2){
                sb.insert(0,"亿");
            }
        }
        sb = sb.reverse();
        for (int i = 0; i < sb.length(); i++){
            String s2 = sb.substring(i,i + 1);
            if (s2 == "零"){
                if (sb.substring(i - 1,i) == "零")
                {
                    sb.replace(i,i + 1,"");
                    i--;
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static StringBuilder change(String s){
        StringBuilder sb = new StringBuilder();
        Integer n = new Integer(s);
        for (int i = 1000; i > 0; i /= 10){
            n = n / i;
            int temp = n;
            if (i == 1000){
                if (temp != 0){
                    if (temp != 1)
                        sb.append(swap(temp));
                    sb.append("千");
                }else {
                    sb.append(swap(temp));
                }
            }
            if (i == 100){
                if (temp != 0){
                    if (temp != 1)
                        sb.append(swap(temp));
                    sb.append("百");
                }else {
                    sb.append(swap(temp));
                }
            }
            if (i == 10){
                if (temp != 0){
                    if (temp != 1)
                        sb.append(swap(temp));
                    sb.append("十");
                }else {
                    sb.append(swap(temp));
                }
            }
        }
        Integer last = new Integer(s.charAt(s.length() - 1));
        sb.append(swap(last));
        return sb;
    }

    private static String swap(int n){
        StringBuilder sb = new StringBuilder();
        switch (n){
            case 1:
                sb.append("一");
                break;
            case 2:
                sb.append("二");
                break;
            case 3:
                sb.append("三");
                break;
            case 4:
                sb.append("四");
                break;
            case 5:
                sb.append("五");
                break;
            case 6:
                sb.append("六");
                break;
            case 7:
                sb.append("七");
                break;
            case 8:
                sb.append("八");
                break;
            case 9:
                sb.append("九");
                break;
            case 0:
                sb.append("零");
                break;
        }
        return sb.toString();
    }
}
