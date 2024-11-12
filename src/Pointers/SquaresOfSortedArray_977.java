package Pointers;

/**
 * 双指针经典
 */
public class SquaresOfSortedArray_977 {
    public int[] solution(int[] nums){
        int len = nums.length;
        int l = 0, r = len - 1;
        int[] res = new int[len];
        while(l <= r){
            if(nums[l] * nums[l] <= nums[r] * nums[r]){
                res[len - 1] = nums[r] * nums[r];
                r--;
            }else{
                res[len - 1] = nums[l] * nums[l];
                l++;
            }
            len--;
        }
        return res;
    }
}
