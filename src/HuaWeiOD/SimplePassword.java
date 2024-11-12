package HuaWeiOD;

import java.util.Scanner;

/**
 * 现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0，把密码中出现的小写字母都变成九键键盘对应的数字，如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1≤n≤100
 */

public class SimplePassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                if (chars[i] >= 'A' && chars[i] < 'Z'){
                    chars[i] += 33;
                } else if(chars[i] == 'Z'){
                    chars[i] = 'a';
                } else if(chars[i] >= 'a' && chars[i] <= 'z'){
                        if (chars[i] == 'a' || chars[i] == 'b' || chars[i] == 'c') {
                            chars[i] = '2';
                        }
                        if (chars[i] == 'd' || chars[i] == 'e' || chars[i] == 'f') {
                            chars[i] = '3';
                        }
                        if (chars[i] == 'g' || chars[i] == 'h' || chars[i] == 'i') {
                            chars[i] = '4';
                        }
                        if (chars[i] == 'j' || chars[i] == 'k' || chars[i] == 'l') {
                            chars[i] = '5';
                        }
                        if (chars[i] == 'm' || chars[i] == 'n' || chars[i] == 'o') {
                            chars[i] = '6';
                        }
                        if (chars[i] == 'p' || chars[i] == 'q' || chars[i] == 'r' ||
                                chars[i] == 's') {
                            chars[i] = '2';
                        }
                        if (chars[i] == 't' || chars[i] == 'u' || chars[i] == 'v') {
                            chars[i] = '8';
                        }
                        if (chars[i] == 'w' || chars[i] == 'x' || chars[i] == 'y' ||
                                chars[i] == 'z') {
                            chars[i] = '9';
                        }
                    }
                    System.out.print(chars[i]);
                }
            }
        }
    }
