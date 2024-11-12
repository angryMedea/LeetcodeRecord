package Hot100;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers_448 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution(nums));
    }

    public static List<Integer> solution(int[] nums){
        List<Integer> results = new ArrayList<>();
        //1.先把元素转换为对应的下标（所以要相应的-1）
        //2.再把出现了的下标的元素标记为负数
        //3.可能还未转换为下标就被标记为负数了，因此要取绝对值
        for (int i = 0; i < nums.length; i++) {
            //约束条件：元素必须为正数才能被标记为负数，否则跳过
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = - nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //元素仍为正的，说明下标没有在元素中出现过，取该元素的下标+1
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }
        return results;
    }
}
