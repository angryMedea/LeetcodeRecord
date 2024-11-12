package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 和 242，1 类似，不同的是要考虑把什么放进哈希表，和如何统计次数
 */
public class FourSum_454 {

    public int solution(int[] nums1,int[] nums2,int[] nums3,int[] nums4){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int n : nums1){
            for(int m : nums2){
                map.put(m+n,map.getOrDefault(m+n,0) + 1);
            }
        }

        for(int n : nums3){
            for(int m: nums4){
                if(map.containsKey(-(n+m))){
                    /**
                     * 注意：这里统计次数不能是单纯的 count++
                     * 因为hashmap中可能出现重复的key
                     * 只要满足 key + m + n = 0 都算作一种解法
                     * 所以一共是 map.get(-(n+m))种解法
                     * 相当于 求排列组合的种类 是m*n的解法
                     */
                    count += map.get(-(n+m));
                }
            }
        }
        return count;
    }
}
