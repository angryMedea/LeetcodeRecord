package Binary;

/**
 *  Find Minimum in Rotated Sorted Array
 *  Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 *
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum element of this array.
 *
 * You must write an algorithm that runs O(log n) time.
 */
public class FindMin_153 {
    public static void main(String[] args) {
        FindMin_153 find = new FindMin_153();
//        int[] nums = {11,13,15,17};
        int[] nums = {5,6,7,1,2};
        int min = find.findMin(nums);
        System.out.println(min);
    }

//    public int findMin(int[] nums) {
//        if(nums.length == 1) return nums[0];
//
//        int r = nums.length - 1;
//        int l = 0;
//        while(l < r){
//            int m = l + r + 1 >> 1;
//            if(nums[m] > nums[0]){
//                l = m;
//            }else
//                r = m - 1;
//        }
//        return r == nums.length - 1? nums[0]:nums[r + 1];
//    }

    /**
     * 【二分法】的本质是【二段性】，而非单调性
     * 只要一段满足某一条件，另一段不满足，就可以使用【二分法】
     * 在下面的解法中，采用的条件是：当right落在后半段时，mid落在前半段时，nums[mid] > nums[right]
     *                          否则，只要right落在了前半段，就不满足 nums[mid] > nums[right]
     * 跳出循环时，会返回满足 nums[mid] > nums[right] 的第一个 right，即 后半段的第一个数字。
     */
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                //mid向小取整，即找到小于nums[right]的第一个元素，即最小值
                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return nums[left];
        }
}
