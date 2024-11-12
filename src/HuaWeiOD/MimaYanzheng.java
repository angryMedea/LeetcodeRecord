package HuaWeiOD;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MimaYanzheng {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            if(str.length() < 9){
                System.out.println("NG");
                continue;
            }
            if(noType(str)){
                System.out.println("NG");
                continue;
            }
            if(hasRep(str)){
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
    public static boolean hasRep(String str){
        int n = str.length();
        for(int i = 3; i < n; i++){
            if(str.substring(i).contains(str.substring(i-3,i))){
                return true;
            }
        }
        return false;
    }

    public static boolean noType(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[\\W]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3){
            return false;
        }else return true;
    }
}
