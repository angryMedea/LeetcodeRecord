package Pointers;

public class FindKthLargest_215 {
    public static void main(String[] args) {
        FindKthLargest_215 find = new FindKthLargest_215();
        int[] nums = {2,1};
        System.out.println(find.findKthLargest(nums, 1));
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int[] array = quickSort(nums, left, right);
        return array[len - k];
    }

    public int[] quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
        return nums;
    }

    /**
     * 双指针顺序遍历，不太好懂
     * @param nums
     * @param m
     * @param n
     */
//    public int partition(int[] nums, int left, int right) {
//        // 基准值
//        int pivot = nums[left];
//        int lt = left;
//        // 循环不变量：
//        // all in [left + 1, lt] < pivot
//        // all in [lt + 1, i) >= pivot
//        for (int i = left + 1; i <= right; i++) {
//            if (nums[i] < pivot) {
//                lt++;
//                swap(nums, i, lt);
//            }
//        }
//        swap(nums, left, lt);
//        return lt;
//    }

    /**
     * 双指针对撞遍历，更直观好懂
     * @param nums 原始数组
     * @param
     * @param
     * @return pivot的下标
     */
//    public int partition(int[] nums, int left, int right){
//        int pivot = nums[left];
//        int lt = left + 1;
//        int gt = right;
//
//        while(true){
//            while(lt <= right && nums[lt] < pivot){
//                lt++;
//            }
//            while(gt > left && nums[gt] > pivot){
//                gt--;
//            }
//            if(lt >= gt){
//                break;
//            }
//            swap(nums,lt,gt);
//        }
//        swap(nums,left,gt);
//        return gt;
//    }

    int partition(int[] nums, int l, int r){
        int loc = l;
        int start = l;
        int end = r;

        while(start < end){
            while(start < r && nums[start] <= nums[loc]){
                start++;
            }
            while(end > l && nums[end] > nums[loc]){
                end--;
            }
            if(start < end){
                swap(nums, start, end);
            }
        }
        swap(nums, l, end);
        return end;
    }

    public void swap(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }
}
