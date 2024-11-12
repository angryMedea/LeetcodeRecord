package Amazon;

import java.util.*;

public class findRecurringNames {
    public static void main(String[] args) {
        String[] strings1 = {"tom", "jerry"};
        String[] strings2 = {"reyjr", "mot", "tom", "jerry", "mto"};
        System.out.println(Arrays.toString(solution(strings1, strings2)));
    }


    public static String[] solution(String[] realNames, String[] allNames) {
        Map<String, String> map1 = new HashMap<>();
        for(String realName:realNames){
            char[] m = realName.toCharArray();
            Arrays.sort(m);
            String n = new String(m);
            map1.put(n,realName);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for(String allName:allNames){
            char[] i = allName.toCharArray();
            Arrays.sort(i);
            String j = new String(i);
            map2.put(j,map2.getOrDefault(j,0) + 1);
        }
        List<String> res = new ArrayList<>();
        for(String n:map1.keySet()){
            if (map2.containsKey(n) && map2.get(n) > 1) {
                res.add(map1.get(n));
            }
        }
        String[] result = res.toArray(new String[0]);
        Arrays.sort(result);

        return res.isEmpty()? new String[]{"None"}:result;

    }

}
