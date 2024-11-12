package HuaWeiOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A、B两个人把苹果分为两堆，A希望按照他的计算规则等分苹果，他的计算规则是按照二进制加法计算，并且不计算进位 12+5=9（1100 + 0101 = 9），B的计算规则是十进制加法，包括正常进位，B希望在满足A的情况下获取苹果重量最多。
 *
 * 输入苹果的数量和每个苹果重量，输出满足A的情况下B获取的苹果总重量。
 *
 * 如果无法满足A的要求，输出-1。
 *
 * 输入描述：
 * 输入第一行是苹果数量：3
 * 输入第二行是每个苹果重量：3 5 6
 *
 * 输出描述：
 * 输出第一行是B获取的苹果总重量：11
 *
 * 苹果数量<=20000，苹果重量<=10000
 */

public class FenPingGuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("苹果数量：");
        int num = Integer.parseInt(sc.nextLine());

        System.out.println("苹果重量：");
        while (sc.hasNext()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                list.add(sc.nextInt());
            }

            int min = 10001;
            int aWeight = 0;
            int bWeight = 0;

            for (int weight : list) {
                aWeight ^= weight;
                bWeight += weight;
                min = Math.min(min,weight);
            }

            if (aWeight == 0){
                System.out.println(bWeight - min);
            }else System.out.println(-1);
        }
    }
}
