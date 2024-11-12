package Amazon;

import com.sun.codemodel.internal.JForEach;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class getSmallestPalindrome {
    public static void main(String[] args) {
//        String s = "bx??tm";
//        String s = "ai?a??u";
        String s = "a?rt???";
        String result = findLexicographicallySmallestPalindrome(s);
        System.out.println(result);  // Output: "aaiuiaa"
    }


    public static String findLexicographicallySmallestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int l = chars.length;
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        if (map.get('?') < map.size() - 1 ) return "-1";
        char[] chars1 = new char[l];
        char max = 'a';
        for(char key : map.keySet()){
            if (key - max > 0) max = key;
        }
        chars1[l/2] = max;
        return "no idea";
    }
}

