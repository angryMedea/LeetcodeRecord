package Binary;

/**
 * 核心是找到答案的边界，要自己设定最大最小值从而进行二分
 *
 * 1.如何确定最大值和最小值
 * 2.如何向上取整
 */

public class SmallestDivisor_1283 {
    public static void main(String[] args) {
        SmallestDivisor_1283 smallestDivisor = new SmallestDivisor_1283();
        int[] nums = {1,9,5,2};
        int threshold = 6;
        int i = smallestDivisor.solution(nums, threshold);
        System.out.println(i);
    }

    public int solution(int[] nums, int threshold) {

        int n = nums.length;
        int max = nums[0];
        for(int j = 0; j < n; j ++){
            if(nums[j] > max) max = nums[j];
        }

        int r = max , l = 1;
        while(l < r){
            int m = l + r >> 1;
            if(calSum(nums,m) > threshold) l = m + 1;
            else r = m;
        }
        return l;

//        int n = nums.length;
//        int max = nums[0];
//        for(int j = 0; j < n; j ++){
//            if(nums[j] > max) max = nums[j];
//        }
//
//        int r = max - 1 , l = 0;
//        int div, sum = 0;
//        while(l < r){
//            int m = l + r >> 1;
//            for(int i = 0; i < n; i ++){
//                div = nums[i] / m + (nums[i] % m != 0 ? 1 : 0);
//                sum += div;
//            }
        /**
         * 错误！！！！
         * 区间收缩条件设置反了
         */
//            if(sum > threshold) r = m;
//            else l = m + 1;
//        }
//
//        int i;
//        for (i = 1; i <= l; i++) {
//            int div1, sum1 = 0;
//            for (int j = 0; j < n; j++) {
//                div1 = nums[j] / i + (nums[j] % i != 0 ? 1 : 0);
//                sum1 += div1;
//            }
//            if (sum1 <= threshold) break;
//        }
//        return i;
    }

    private int calSum(int[] nums, int divisor){
        int sum = 0;
        for (int num:nums) {
            sum += num / divisor + (num % divisor != 0? 1 : 0);
        }
        return sum;
    }
}
