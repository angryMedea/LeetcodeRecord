package Greedy;

/**
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative.
 * A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.
 * 计算峰值，忽略单调坡度上的值
 * 特殊情况：1.上下坡有平坡
 *         2.首尾元素
 *         3.单调坡中有平坡
 */
public class WiggleSubsequence_376 {
    public int solution(int[] nums){
        if(nums.length == 1) return 1;
        int prediff = 0, currdiff = 0;
        // 摆动序列的初始值为1，因为题目规定了只有一个元素也是摆动序列
        int result = 1;
        // i不用遍历到数组最后一个元素，因为首尾元素都算在摆动序列里面
        // 并且此时i+1会越界
        for(int i = 0; i < nums.length - 1;i++){
            currdiff = nums[i + 1] - nums[i];
            //prediff == 0是针对 1.只有2个元素 2. 首元素出现平坡(e.g. 2.2.2.5.4)时只计算最后一个prediff
            if((prediff >= 0 && currdiff < 0) || (prediff <= 0 && currdiff > 0)){
                result++;
                // 只在出现坡度的时候更新prediff，针对在单调坡中出现平坡(e.g. 1.2.33333.7.1.4)
                prediff = currdiff;
            }
        }
        return result;
    }

}
