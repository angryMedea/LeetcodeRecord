package HuaWeiOD;

import java.util.*;

/**
 * 实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 数据范围：输入的字符串长度满足1≤n≤20  ，保证输入的字符串中仅出现小写字母
 */
public class DeleteMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        Collection<Integer> values = map.values();
        Integer min = Collections.min(values);
        for(Character c:map.keySet()){
            if(map.get(c).equals(min)){
                str = str.replace(String.valueOf(c),"");
            }
        }
        System.out.println(str);
    }
}
