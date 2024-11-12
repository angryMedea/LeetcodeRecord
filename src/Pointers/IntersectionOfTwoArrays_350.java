package Pointers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 解题思路：
 * 1.排序
 * 2.双指针遍历两个数组，如果数组1小，1的下标右移，2小2右移
 * 3.如果相等，加入目标数组，直到退出循环
 * 4.返回目标数组中被小表index放过数的数组范围（用数组存的话最后要用Arrays.copyOfRange()方法取）
 * 5.时间复杂度两个数组恰好全部遍历完,不算排序，时间复杂度o(m+n) 空间复杂度 o(min(m,n))
 */

public class IntersectionOfTwoArrays_350 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {4,8,9,4,9};
        System.out.println(Arrays.toString(solution(nums1, nums2)));
    }

    public static int[] solution(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < len1 && j < len2){
            if(nums1[i] == nums2[j]){
                stack.push(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else j++;
        }

        int size = stack.size();
        int[] ans = new int[size];
        //题目中说不考虑输出的顺序，可用栈
        for(int k = 0; k < size; k++){
            ans[k] = stack.pop();
        }

        return ans;
    }
}
