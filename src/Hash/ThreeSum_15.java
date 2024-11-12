package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 很难的一题，要想清楚怎么去重
 * 每组答案中的三个数不能完全一样
 * e.g [0,1,-1]和[1,-1,0]就是重复的
 * 去重的方法：三个指针都要分别去重，第一个指针continue跳过，第二个、三个指针++跳过
 */
public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        ThreeSum_15 sum15 = new ThreeSum_15();
        System.out.println(sum15.threeSum(nums));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // 一定要排序，否则难度太大，不方便去重
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0; k < nums.length; k++){
            // 如果排序后的第一个元素就>0,说明无解
            if(nums[k] > 0) break;
            // 如果下一个元素和前一个元素相等，跳过
            if(k > 0 && nums[k] == nums[k-1]) continue;
            int i = k + 1, j = nums.length - 1;
            // 双指针思路，固定k指针，移动i\j指针相向移动
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum < 0) i++;
                if(sum > 0) j--;
                if(sum == 0){
                    res.add(Arrays.asList(nums[k],nums[i],nums[j]));
                    while(i < j && nums[i] == nums[i+1]) i++;//一定用while去重，跳过所有重复的元素
                    while(i < j && nums[j] == nums[j-1]) j--;
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
