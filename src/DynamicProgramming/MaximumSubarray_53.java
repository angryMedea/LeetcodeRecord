package DynamicProgramming;

/** dp五部曲
 * - dp数组及下标的含义
 * 以nums[i]为结尾的最大连续子序列和
 * - 递推公式
 * dp[i] = max(dp[i-1]+nums[i],nums[i])
 * - dp数组如何初始化
 * dp[0] = nums[0]，其他位置都默认值0
 * - 遍历顺序
 * 从i=1开始从前往后遍历，正常遍历
 * 最后的结果是dp中最大的元素
 * - 打印dp数组(用来测试是否正确)
 */
public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max_sum = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            max_sum = Math.max(dp[i],max_sum);
        }
        return max_sum;
    }
}
