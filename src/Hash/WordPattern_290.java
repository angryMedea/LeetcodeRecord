package Hash;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {
    public static void main(String[] args) {
        String patter = "aaa";
        String s = "cat cat cat cat";
        System.out.println(wordPattern(patter, s));
    }

    static boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if(pattern.length() != strings.length) return false;
        Map<Character,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!map1.getOrDefault(pattern.charAt(i),-1).equals(map2.getOrDefault(strings[i],-1))){
                return false;
            }
            map1.put(pattern.charAt(i),i);
            map2.put(strings[i],i);
        }

        return true;

//        String[] strs = s.split(" ");
//        if(pattern.length() != strs.length) return false;
//        for(int i = 0;i<pattern.length();i++){
//            if(pattern.indexOf(pattern.charAt(i)) != firstIndex(strs,i)){
//                return false;
//            }
//        }
//        return true;
    }

//    static int firstIndex(String[] strs,int n){
//        for(int i = 0;i< strs.length;i++){
//            if(strs[i].equals(strs[n])){
//                return i;
//            }
//        }
//        return -1;
//    }
}
