package Binary;

public class RotatedSortedArray_33 {
    public static void main(String[] args) {
        RotatedSortedArray_33 array33 = new RotatedSortedArray_33();
        int[] nums = {1,2};
        int target = 2;
        int i = array33.search(nums, target);
        System.out.println(i);
    }

        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;

            if(nums.length == 0) return -1;
            if(nums.length == 1) return nums[0] == target? 0:-1;

            while(l <= r){
                int m = (l + r) >> 1;
                if(nums[m] == target){
                    return m;
                }
                /**
                 * 以下的方法在确定范围时很容易出错，个人不喜欢这种写法
                 */
                if (nums[m] >= nums[l]){//以二分点元素是否大于nums[l]为限制划分两个区域
                    if (nums[m] >= target && target >= nums[l]){
                        //注意：这个范围只能这么写，必须考虑到除此范围外的所有情况
                        //如果写成if(target > nums[m]),那么else的情况会更加复杂，不能仅仅用r = m限制，所以只能在if里写r=m的条件
                        r = m;
                    }else{
                        l = m + 1;
                    }
                }else{
                    //同理，if中的条件只能写l=m的情况，否则else的情况无法只用l=m概括
                    if (nums[m] <= target && target <= nums[r]){
                        l = m;
                    }else{
                        r = m - 1;
                    }
                }
            }

            return nums[l] == target ? l:-1;

//            int n = nums.length;
//            //先排除两种情况：数组为null和仅有一个元素
//            if (n == 0) return -1;
//            if (n == 1) return nums[0] == target ? 0 : -1;
            /**
             * 以下的方法先求扭转点再以扭转点为界分开讨论，逻辑上更简单清楚
             */
//            // 第一次「二分」：从中间开始找，找到满足 >=nums[0] 的分割点（旋转点）
//            int l = 0, r = n - 1;
//            while (l < r) {
//                /**
//                 * 此处，mid 不+1的话会导致死循环
//                 * l = mid 这种小取整，到区间只剩2个元素的时候，区间无法缩小
//                 */
//                int mid = l + r + 1 >> 1;// mid向大取整，找到大于nums[0]的最后一个元素，即旋转点
//                if (nums[mid] >= nums[0]) {
//                    /**
//                     * 同理，l指针不断右移，直到l=r，跳出循环
//                     * 此时，l=r=分割点
//                     */
//                    l = mid;
//                } else {
//                    r = mid - 1;
//                }
//            }
//
//            // 第二次「二分」：通过和 nums[0] 进行比较，得知 target 是在旋转点的左边还是右边
//            if (target >= nums[0]) {
//                l = 0;//target在分割点左边的区间，左边界下标为0，左边界为分割点
//            } else {
//                /**
//                 * 当target < nums[0]，
//                 * 且旋转点就是nums[0]时，即 实际上是没有旋转，数组是单调递增的
//                 * l = l + 1 会出现越界
//                 */
//                l = l + 1;//target在分割点右边的区间，左边界下标是分割点后一个元素
//                r = n - 1;
//            }
//            while (l < r) {
//                int mid = l + r >> 1;
//                /**
//                 * 这里还是没搞懂为什么必须用 nums[mid] >= target
//                 * 用 nums[mid] <= target，会陷入死循环
//                 *
//                 * 因为 mid是向小取整
//                 * 如果 区间最后只剩下两个元素 nums[mid]会一直 < target
//                 * 这样 l就可以保持右移 区间不断缩小 最后跳出循环
//                 *
//                 * 如何 用 nums[mid] <= target 则 mid要改成 mid = l + r + 1 >> 1
//                 */
//                if (nums[mid] >= target) {
//                    r = mid;
//                } else {
//                    l = mid + 1;
//                }
//            }
//            /**
//             * 只能用r,用l可能出现越界
//             */
//            return nums[r] == target ? r : -1;
        }
    }

