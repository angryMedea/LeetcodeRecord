package TopInterview150;

import java.util.Arrays;

public class RotateArray_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        Solution solution = new Solution();
        int[] rotate = solution.rotate(nums, k);
        System.out.println(Arrays.toString(rotate));
    }
}

class Solution {
    public int[] rotate(int[] nums, int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //把原数组值放到一个临时数组中，
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //然后在把临时数组的值重新放到原数组，并且往右移动k位
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
        return nums;
        //下面这种方法存在错误，因为无法将原地替换的数组完全按照顺序存储在新数组中
//        int m = nums.length;
//        int n = k % m;
//        int[] array = new int[m - n];
//        int j = 0;
//        for(int i = m - 1; i >= 0; i--){
//            if(m - i <= n){
//                array[j++] = nums[n + i - m];
//                nums[n + i - m] = nums[i];
//            }
//        }
//        for(int l = array.length - 1; l >= 0; l--){
//            nums[n++] = array[l];
//        }
//        return nums;
    }
}
