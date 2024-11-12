package Hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public static void main(String[] args) {
        TwoSum_1 ts = new TwoSum_1();
        int[] nums = {3,3};
        int target = 6;
        int[] ints = ts.twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 暴力解法，时间复杂度为 O(n^2)
     * @param nums
     * @param target
     * @return
     */
//    public int[] twoSum(int[] nums, int target) {
//        int[] arr = new int[2];
//        int sum = 0;
//        int n = nums.length;
//        for(int i = 0; i < n; i++) {
//            for (int j = n - 1; j > i; j--) {
//                sum = nums[i] + nums[j];
//                if (sum == target) {
//                    arr = new int[]{i, j};
//                }
//            }
//        }
//        return arr;
//    }

    /**
     * 哈希查找优化，时间复杂度：O(n)
     * key = nums[i]
     * value = i
     * 为什么要把元素放在key，下标放在value？
     * 因为我们是要快速查找（target - key）是否有对应的key，要查找的对象放在key
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            /**
             * 一开始哈希表是空的，所以遍历后要把元素放入哈希表中
             * 注意：这里不用担心元素重复无法放入map中，因为题目进行了限制
             * //你可以假设每种输入只会对应一个答案
             * 但是，数组中同一个元素在答案里不能重复出现。//
             * 元素若相同，则第二个元素必然只会显示下标而不会被放入map中
             */
            map.put(nums[i], i);
        }
        return new int[0];

        //一样是暴力解法，同向指针
//        int len = nums.length;
//        int start = 0;
//        int end = start + 1;
//
//        while (start < len) {
//            while (end < len) {
//                if (nums[end] == target - nums[start]) {
//                    break;
//                }
//                end++;
//            }
//            if(end < len && nums[end] == target - nums[start]){
//                break;
//            }
//            else{
//                start++;
//                end = start + 1;
//            }
//        }
//        return new int[]{start, end};
    }
}
