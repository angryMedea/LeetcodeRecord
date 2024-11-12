package HuaWeiOD;

import java.util.Scanner;

public class Zhao1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int  n = in.nextInt();
        String m = Integer.toString(n,2);
        int len = m.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (m.charAt(i) == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
