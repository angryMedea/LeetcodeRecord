package HuaWeiOD;

import java.util.Scanner;

/**
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * 坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 下面是一个简单的例子 如：
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 处理过程：
 * 起点（0,0）
 * +   A10   =  （-10,0）
 * +   S20   =  (-10,-20)
 * +   W10  =  (-10,-10)
 * +   D30  =  (20,-10)
 * +   x    =  无效
 * +   A1A   =  无效
 * +   B10A11   =  无效
 * +  一个空 不影响
 * +   A10  =  (10,-10)
 * 结果 （10， -10）
 */
public class ZuobiaoYidong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(";");
        int x = 0, y = 0;
        for (String s : strings) {
//            char[] chars = s.substring(1).toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                if (!(chars[i] >= 65 && chars[i] <= 122)) {
//
//                }
//            }
//            if (!s.equals("")){
//            try {
//                val = Integer.parseInt(s.substring(1));
//            } catch (NumberFormatException e) {
//                continue;
//            }
//            }else{
//                continue;
//            }
            /**
             * 注意学会使用正则表达式来检测字符串是否符合某规则，根据某规则切分字符串
             * 或 替换符合规则的文本
             */
            if (!s.matches("[WASD][0-9]{1,2}")){
                continue;
                //注意！！！
                //continue的作用是结束本次循环，开始下次循环
                //就是说if条件满足后，后面的语句都不会执行，
                //会返回for循环开始下一次循环
            }
            int val = Integer.parseInt(s.substring(1));
            switch (s.charAt(0)) {
                case 'A':
                    x -= val;
                    break;
                case 'S':
                    y -= val;
                    break;
                case 'W':
                    y += val;
                    break;
                case 'D':
                    x += val;
                    break;
            }
        }
        System.out.println("(" + x + "," + y + ")");
    }
}
