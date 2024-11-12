package Hash;

import java.util.HashMap;


public class RansomNote_383 {
    public static void main(String[] args) {
        String r = "aab";
        String m = "baa";
        System.out.println(canConstruct(r, m));
    }

    static boolean canConstruct(String ransomNote, String magazine) {
//        Map<Integer,Character> map = new HashMap<>();
//        int count = 1;
//        int n;
//        for(int i = 0; i < magazine.length(); i++){
//            map.put(i,magazine.charAt(i));
//        }
//
//        for(int j = 0; j < ransomNote.length(); j++){
//            char c = ransomNote.charAt(j);
//            if(map.containsValue(c)){
//                map.remove(map.)
//                if(n < 0){
//                    return false;
//                }
//            }else return false;
//        }
//        return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c) || map.get(c) < 1) return false;
            map.put(c, map.get(c) - 1);
        }

        return true;
    }
}
