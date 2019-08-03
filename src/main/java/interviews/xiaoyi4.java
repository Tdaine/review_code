package interviews;

import java.util.Scanner;

/**
 * @author abaka
 * @date 2019/8/3 16:10
 */
public class xiaoyi4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            String s = in.next();
            if (s.length() <= 0){
                System.out.println("NO");
                return;
            }
            String revs = rev(s);
            for (int i = 0; i < n; i++){
                String t = in.next();
                if (t.length() > 1000 || t.length() < s.length() || t.length() < revs.length()){
                    System.out.println("NO");
                    return;
                }
                if (revs.length() != 0){
                    while (t.startsWith(s) || t.startsWith(revs)){
                        if (t.startsWith(s))
                            t = t.substring(s.length());
                        else
                            t = t.substring(revs.length());
                        if (t.length() == 0){
                            System.out.println("YES");
                            return;
                        }
                    }
                }else {
                    while (t.startsWith(s)){
                        if (t.startsWith(s))
                            t = t.substring(s.length());
                        if (t.length() == 0){
                            System.out.println("YES");
                            return;
                        }
                    }
                }
                System.out.println("NO");
            }
        }
        in.close();
    }
    private static String rev(String s){
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1' && flag != 0)
                sb.append('0');
            else if (s.charAt(i) == '0'){
                sb.append('1');
                flag++;
            }
        }
        return sb.toString();
    }
}
