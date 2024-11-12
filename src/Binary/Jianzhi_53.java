package Binary;

/**
 * 题目：统计一个数字在排序数组中出现的次数。
 * 个人觉得最好理解的思路是：二分单边 + 线性扫描
 * 所以首先会找到第一个target出现的点，就是左边界，然后对右区间进行扫描
 */
public class Jianzhi_53 {
    public static void main(String[] args) {
        Jianzhi_53 jianzhi_53 = new Jianzhi_53();
        int[] nums = {2,3,3,3,3,3,3};
        int target = 3;
        int count = jianzhi_53.search(nums,target);
        System.out.println(count);
    }

    public int search(int[] nums, int t) {
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while(l < r){//这里不能加=，因为l=r的情况就是一个元素的数组，此时左右边界必相等，就不能跳出循环
            int m = l + (r - l)/2;//这里根据除法的规则，m会落在偏左的位置，因此是第一个target出现的下标
            /**
             * 注意：这里的判断条件只能写成nums[m] >= t
             * 因为：跳出循环的条件是l=r，当判断条件满足时，r指针会不断向左移动，直到r=l跳出循环
             * 此时r最终返回的值就是最左边，即第一个满足判断条件的值
             *
             * 若 判断条件为 nums[m] <= t
             * 则 l=m,l指针不断向右移动，最终返回的最右边，即最后一个满足判断条件的值
             */
            if(nums[m] >= t){
                r = m;
            }else
                l = m + 1;
        }
        /**
         * while循环条件要注意，l++ >= 0 是为了保证数组至少有一个元素
         */
//        while (l >= 0 && nums[l] == t){
        while (l < nums.length && nums[l] == t && l++ >= 0){
            count ++;
        }
        return count;

    }
}
