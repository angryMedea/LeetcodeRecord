package HuaWeiOD;

import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){//连续输入要先判断是否下面还有数据
            String s = sc.nextLine();
            //不管长度是大于还是小于8，只要不是8的倍数，
            //有余数就用0补齐
            //为什么要补8个0？因为s的长度最小可能为0，补齐8个0可以保证s.length()>=8
            if(s.length()%8 !=0 )
                s = s + "00000000";

            while(s.length()>=8){
                //先取1-8个字符
                System.out.println(s.substring(0, 8));
                //然后把后面的9-length的字符重新赋值为一个字符串
                //这样就可以保证循环输出
                //当长度不足8时，自动停止输出
                s = s.substring(8);
            }
        }
    }
}
