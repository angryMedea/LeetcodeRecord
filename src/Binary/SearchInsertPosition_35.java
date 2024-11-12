package Binary;

public class SearchInsertPosition_35 {
    public static void main(String[] args) {
        int[] nums = {3,4,9,11,12,14};
        int target = 1;
        int i = new SearchInsertPosition_35().searchInsert(nums, target);
        System.out.println(i);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while(left < right){
            mid =  (left + right)>>>1;//无符号右移不会溢出
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid ;
            }else{
                left = mid + 1;
            }
        }
        return target > nums[right]? right + 1:left;
    }
}
