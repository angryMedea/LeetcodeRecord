package HuaWeiOD;

import java.util.HashMap;
import java.util.Scanner;

public class ZhiShuYinZi {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 25;
        int max0 = (int)Math.sqrt(n);

        for(int i = 2; i < max0; i++){
            while(n%i == 0 && isPrime(i)){
                System.out.print(i + " ");
                n /= i;
            }
        }
        System.out.print(n == 1? "":n);
       HashMap<Integer,Integer> map = new HashMap<>();

    }

    public static boolean isPrime(int n){
        int max1 = (int)Math.sqrt(n);
        for(int i = 2; i <= max1; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
