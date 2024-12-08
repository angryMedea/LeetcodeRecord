package Pointers;

import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] merge = merge2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(merge));
    }

    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) return nums2;
        if (n == 0) return nums1;

        int len = nums1.length;
        int[] array = new int[len];
        int t = 0;
        int l = 0;
        int r = 0;
        while (l < m && r < n && t < len) {
            if (nums1[l] <= nums2[r]) {
                array[t] = nums1[l];
                l++;
            } else {
                array[t] = nums2[r];
                r++;
            }
            t++;
        }
        while (l < m) {
            array[t++] = nums1[l++];
        }
        while (r < n) {
            array[t++] = nums2[r++];
        }
        System.arraycopy(array,0,nums1,0,m+n);
        return nums1;
    }

    /**
     * Actually, the result should not be returned as a new array but instead be stored in the nums1
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public static int[] merge2(int[] nums1, int m, int[] nums2, int n){
        int k = m + n - 1;
        int j = m - 1;
        int l = n - 1;
        while(j >= 0 || l >= 0){
            if(j >= 0 && l >= 0){
                nums1[k--] = nums1[j] < nums2[l]? nums2[l--]:nums1[j--];
            }else if (j >= 0){
                nums1[k--] = nums1[j--];
            }else {
                nums1[k--] = nums2[l--];
            }

        }
        return nums1;
    }

    // 以nums2指针作为主循环条件，当指针指向负数时，nums1的指针直接不变保持在原地就行
    // 因为这意味着剩下的元素就是nums1本身的原始数据，且它们已经在原地，无需移动
    public static int[] merge3(int[] nums1, int m, int[] nums2, int n){
        int k = m + n - 1;
        int j = m - 1;
        int l = n - 1;
        //when l<0,no need to deal with j
        //because nums1 has been ordered
        while(l >= 0){
            if(j >= 0 && nums1[j] > nums2[l]){
                nums1[k--] = nums1[j--];
            }else{// when j < 0 or nums1[j] <= nums[l]
                nums1[k--] = nums2[l--];
            }
        }
        return nums1;
    }
}