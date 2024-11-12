package Hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntersectionTwoArraysII_350 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int num:nums2){
            if (map.containsKey(num) && map.get(num) > 0){
                list.add(num);
                map.put(num,map.get(num) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
