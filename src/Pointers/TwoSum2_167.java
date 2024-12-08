package Pointers;

import java.util.Arrays;

public class TwoSum2_167 {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1,1,1,1,1,};
        int target = -2;
        int[] ints = new TwoSum2_167().twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

        public int[] twoSum(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            int[] ans = new int[2];
            while(l <= r - 1){
                while(l < r){
                    int m = target - nums[l];
                    if(nums[r] == m){
                        ans[0] = l;
                        ans[1] = r;
                        break;
                    }else{
                        r--;
                    }
                }
                l++;
                r = nums.length - 1;
            }
            return ans;
        }
    }
