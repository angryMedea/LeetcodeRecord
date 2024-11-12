package Pointers;

import java.util.Arrays;
//字符串相加
public class AddStrings_415 {
    public static void main(String[] args) {
        String num1 = "9999";
        String num2 = "3456";
        System.out.println(solution(num1, num2));
    }

    public static String solution(String num1, String num2) {
         StringBuilder str = new StringBuilder("");
         //设置两个指针分别从尾部开始遍历
         int i = num1.length() - 1;
         int j = num2.length() - 1;
         //设置一个变量来保存是否进位
         int carry = 0;

         while(i >= 0 || j >=0){
             int m = i >= 0? num1.charAt(i) - '0': 0;
             int n = j >= 0? num2.charAt(j) - '0': 0;
             int temp = m + n + carry;
             carry = temp / 10;
             str.append(temp % 10);
             i--;
             j--;
         }

         if(carry == 1) str.append(1);
         return str.reverse().toString();
    }

}
