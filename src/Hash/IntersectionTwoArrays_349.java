package Hash;

import java.util.Set;
import java.util.TreeSet;

public class IntersectionTwoArrays_349 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] nums1, int[] nums2){
        Set<Integer> set = new TreeSet<>();
        for(int num:nums1){
            set.add(num);
        }
        Set<Integer> set2 = new TreeSet<>();
        for(int num:nums2){
            if(set.contains(num)) {
                set2.add(num);
            }
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for (int num:set2){
            arr[i++] = num;
        }

        return arr;
    }
}
