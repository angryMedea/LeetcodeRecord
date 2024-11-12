package Pointers;

import java.util.HashSet;

public class LengthOfLongestSubstring_3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int len = s.length();
        int max_len = 0;
        HashSet<Character> set = new HashSet<>();

        int start = 0;
        for(int end = 0;end < len; end++){
            while(set.contains(s.charAt(end))){
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(end));
            max_len = Math.max(max_len,end - start + 1);
        }
        return max_len;
    }
}
