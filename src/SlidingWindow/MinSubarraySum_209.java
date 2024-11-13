package SlidingWindow;

/**
 * 滑动窗口：快慢指针模版题
 */
public class MinSubarraySum_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution(target, nums));
    }
    public static int solution(int target, int[] nums) {
        int len = nums.length;
        int slow = 0, fast = 0;
        int sum = 0;
        int min = len + 1;
        while(slow < len && fast < len){
            sum += nums[fast];
            while(sum >= target){
                min = Integer.min(min, fast - slow + 1);
                sum -= nums[slow];
                slow++;
            }
            fast++;
        }
        return min == len + 1? 0:min;
    }
}
