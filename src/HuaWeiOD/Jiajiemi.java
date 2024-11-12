package HuaWeiOD;

import java.util.Scanner;

public class Jiajiemi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars1 = in.next().toCharArray();
        char[] chars2 = in.next().toCharArray();
        for(char c:chars1){
            if(c >= 'a' && c < 'z'){
                c -= 31;
            }else if(c >= 'A' && c < 'Z'){
                c += 33;
            }else if(c == 'z'){
                c = 'A';
            }
            else if(c == 'Z'){
                c = 'a';
            }

            if(c >= '0' && c < '9'){
                c += 1;
            }else if(c == '9'){
                c = '0';
            }
            System.out.print(c);
        }
        System.out.println();
        for(char c:chars2){
            if(c > 'a' && c <= 'z'){
                c -= 33;
            }else if(c > 'A' && c <= 'Z'){
                c += 31;
            }else if(c == 'a'){
                c = 'Z';
            }else if(c == 'A'){
                c = 'z';
            }
            if(c > '0' && c <= '9'){
                c -= 1;
            }else if(c == '0'){
                c = '9';
            }
            System.out.print(c);
        }
    }
}
