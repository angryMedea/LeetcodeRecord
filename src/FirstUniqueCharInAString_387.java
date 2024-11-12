import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInAString_387 {
    public static void main(String[] args) {
        String s = "llolov";
        System.out.println(firstUniqChar(s));
    }
    public static int firstUniqChar(String s) {
        Map<Character,Integer> frequency = new HashMap<>();
        int len = s.length();

        for(int i = 0; i < len; i++){
            char ch = s.charAt(i);
            //注意：这里Hashmap加入重复的key值时，会用新的value覆盖旧的value
            frequency.put(ch,frequency.getOrDefault(ch,0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if(frequency.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
