package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 重点看第二种——数组字母映射法
 */
public class ValidAnagram_242 {
    public static void main(String[] args) {
        String s = "car";
        String t = "rac";
        System.out.println(isAnagram1(s, t));
    }

    static boolean isAnagram1(String s, String t) {
        if(s.length()!= t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        for(int i = 0;i < s.length();i++){
            if (map.get(t.charAt(i)) != null){
                if (map.get(t.charAt(i)) > 0){
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                }else return false;
            }else
                return false;
        }
        return true;
    }

    static boolean isAnagram2(String s, String t){
        int[] hash = new int[26];
        int sl = s.length();
        int tl = t.length();
        for (int i = 0; i < sl; i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < tl; i++) {
            hash[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(hash[i] != 0) return false;
        }
        return true;
    }
}
