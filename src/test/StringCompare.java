package test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringCompare {
    public static void main(String[] args) {
//        String s1 = "abcd";
//        String s2 = "aefg";
//        System.out.println(s1.compareTo(s2));
//        Map map = new HashMap();
//        int[] a = {1,2,3,4};
//        String b = Arrays.toString(a);
//        System.out.println(b);
//        String[] c = {"a","b","e","d"};
//        Arrays.sort(c);
//        System.out.println(Arrays.toString(c));
//        String m = "asde";
//        String n = "asdd";
//        System.out.println(m.compareTo(n));
//        int[] f = {1,2,3,4};
//        System.out.println(Arrays.equals(a,f));

//        int s = 13;
        int j = 8;
//        System.out.println(s^j);
        Integer integer = Integer.valueOf(Integer.toBinaryString(j));
        int i = Integer.bitCount(integer);
        int k = Integer.bitCount(8);
        System.out.println(k);
    }
}
