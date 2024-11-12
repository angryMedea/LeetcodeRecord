package HuaWeiOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("用next()方法获取：");
//        if (scanner.hasNext()){
//            String str1 = scanner.next();
//            System.out.println("输出的数据为："+ str1);
//        }
        System.out.println("用nextLine()的方法获取：");
        if (scanner.hasNext()){
            String next = scanner.nextLine();
            System.out.println(next);
        }
        scanner.close();
    }
}
