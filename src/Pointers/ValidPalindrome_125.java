package Pointers;

public class ValidPalindrome_125 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isPalindrome(String s) {
            String str = s.replaceAll("\\s","");
            char[] chars = str.toCharArray();
            int l = 0;
            int r = chars.length - 1;

            while(l < r){
                if(chars[l] == chars[r]){
                    l++;
                    r--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
