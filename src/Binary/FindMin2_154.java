package Binary;

public class FindMin2_154 {
    public static void main(String[] args) {
        FindMin2_154 min = new FindMin2_154();
        int[] nums = {3,1,3,3,3};
        int m = min.findMin(nums);
        System.out.println(m);
    }

    public int findMin(int[] nums) {
//        int n = nums.length;
//            int r = n - 1;
//            int l = 0;
//            while (l < r) {
//                int m = l + r >> 1;
//                if (nums[m] > nums[r]) {
//                    l = m + 1;
//                } else if(nums[m] < nums[r])
//                    r = m;
//                else
//                    r--;
//            }
//            return nums[r];
        /**
         * 如果旋转点是在相同的元素之间，就会失去二段性，此时需要进行预处理
         *  while (l < r && nums[0] == nums[r]) r--
         *  通过将数组尾部和nums[0]相同的元素忽略，就可以恢复二段性了
         */
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r && nums[0] == nums[r]) r--;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]) l = mid;
            else r = mid - 1;
        }
        return r + 1 < n ? nums[r + 1] : nums[0];
        }
}