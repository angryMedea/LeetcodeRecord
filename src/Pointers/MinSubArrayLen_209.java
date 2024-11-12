package Pointers;

public class MinSubArrayLen_209 {
    public static void main(String[] args) {
        int target = 15;
        int[] nums ={1,2,3,4,5};
        System.out.println(solution2(target, nums));
    }
    public static int solution1(int target, int[] nums) {
        int len = nums.length;
        int count = 0;
        int min_len = 0;

        int start = 0;
        for(int end = 0; end < len; end++){
            count += nums[end];
            while(count >= target){
                if(min_len == 0){
                    min_len = end - start + 1;
                }else{
                    min_len = Math.min(min_len,end - start + 1);
                }
                count -= nums[start];
                start++;
            }

            // if(count > target){
            //     start++;
            //     end = start - 1;
            //     count = 0;
            //     continue;
            // }
            // if(count == target){
            //     min_len = Math.min(end - start + 1, min_len);
            // }
        }
        return min_len;
    }

    public static int solution2(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        // 先设置一个不可能的最大值
        int res = len + 1;
        int i = 0;
        for(int j = 0;j < len;j++){
            sum += nums[j];
            //注意这里不能用if，因为要不断缩小左边界，i要在满足条件的情况下一直右移
            while(sum >= target){
                res = Math.min(res,j-i+1);
                sum -= nums[i++];
            }
        }
        // 要注意edge case的情况，检查是不是不存在这个子数组
        return res == len + 1 ? 0:res;
    }
}
