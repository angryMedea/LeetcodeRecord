import java.util.HashMap;
import java.util.Map;
//如何统计字符个数
public class RansomNote_383 {
    public static void main(String[] args) {
        String r = "loveletter";
        String m = "loveletterismine";
        System.out.println(solution2(r, m));
    }

    //哈希法
    public static boolean solution1(String ransomNote, String magazine){
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        Map<Character,Integer> map1 = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();

        for(int i = 0;i < len2; i++){
            char ch = magazine.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0) + 1);
        }

        for(int j = 0; j < len1; j++){
            char ch = ransomNote.charAt(j);
            map1.put(ch,map1.getOrDefault(ch,0) + 1);
        }

        for(int j = 0; j < len1; j++){
            if(map2.get(ransomNote.charAt(j)) != null && map2.get(ransomNote.charAt(j)) >= map1.get(ransomNote.charAt(j))){
                continue;
            }else return false;
        }

        return true;
    }

    public static boolean solution2(String ransomNote, String magazine){
        int[] store = new int[26];
        for (char c : magazine.toCharArray()) {
            store[c - 'a'] ++ ;
        }
        for (char c : ransomNote.toCharArray()) {
            store[c - 'a'] --;
            if (store[c - 'a'] < 0) return false;
        }

        return true;
    }
}
