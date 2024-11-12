package HuaWeiOD;

import java.util.Scanner;

public class FloatToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        float f = sc.nextFloat();
        float n =  (f - (int)f) >= 0.5 ? (int)f + 1 : (int)f;
        System.out.println(n);
    }
}
