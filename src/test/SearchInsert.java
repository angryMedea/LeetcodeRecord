package test;

public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }

    static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if(r == 0) return target > nums[0]? 1:0;
        while(l < r){
            int m = (l + r) >> 1;
            if(nums[m] < target){
                l = m + 1;
            }else r = m;
        }
        if(nums[r] >= target){
            return r;
        }else
            return r + 1;
    }
}
