import java.util.Arrays;

public class MajorityElement_169 {
    /**
     * 这个解法由于用到了排序，sort的时间复杂度是O(n log n)，return是O(1)
     * 所以总体还是O(n log n)
     * 要让时间复杂度优化成O(1)，只能用第二种摩尔投票法
     */
        public int majorityElement1(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }

    /**
     * 核心思想：抵消原则，在一个数组中，如果某个元素出现的次数超过了数组长度的一半（题目预设）
     * 那么这个元素与其他所有元素就能一一配对消消乐，最后剩下的就是这个元素
     * 注意：如果众数的定义不是超过数组长度的一半，这个方法就要变化
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


}
