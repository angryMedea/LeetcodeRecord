package Pointers;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
            int len = nums.length;
            int st = 0;
            int ed = st + 1;
            int sum = nums[st];
            int max_sum = Integer.MIN_VALUE;

            while(st < len && ed < len){
                sum += nums[ed];
                ed++;
                if(nums[st] < 0){
                    st++;
                    ed = st + 1;
                    sum = nums[st];
                } else if(st > 0 && sum < 0){
                    st = ed;
                    ed = st + 1;
                    sum = nums[st];
                }
                max_sum = Math.max(max_sum,sum);
            }
            return len == 1? nums[0]:max_sum;
        }

    }

