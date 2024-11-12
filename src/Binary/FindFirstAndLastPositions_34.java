package Binary;

/**
 * 该解法的事件复杂度不是O(log n)，因为 第一次是二分，第二次是线性扫描
 */
public class FindFirstAndLastPositions_34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums == null || nums.length == 0){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        if(nums.length ==1){
            if(nums[0] == target){
                ans[0] = 0;
                ans[1] = 0;
            }else{
                ans[0] = -1;
                ans[1] = -1;
            }
            return ans;
        }



        int count = 0;
        int n = nums.length;
        int r = n - 1;
        int l = 0;
        while(l < r){
            /**
             * 注意：这里写成 l+r+1>>1 就会陷入死循环
             * why?
             * 当区间不断shrink，最后只剩两个元素的时候，如果写成 l+r+1>>1
             * 那么 m就会一直向上取整，得到的结果nums[m]会一直>= target
             * 此时 r就会一直=m 区间就不会shrink 造成死循环
             * 所以 必须让mid向下取整 让区间只剩2个元素时 nums[m]< target
             * 这样才能保证区间一直shrink 最后跳出循环
             */
            int m = l + r >>1;//mid向下取整
            if(nums[m] >= target){
                r = m;
            }else
                l = m + 1;
        }

        for(int i = l + 1; i < n; i ++){
            if(nums[i] == target){
                count++;
            }
        }
        ans[1] = l + count;
        if (nums[l] == target){
            ans[0] = l;
        }else{
            ans[0] = -1;
            ans[1] = -1;
        }
        return ans;
    }
}
