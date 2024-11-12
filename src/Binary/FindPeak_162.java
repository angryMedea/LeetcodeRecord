package Binary;

public class FindPeak_162 {
    public static void main(String[] args) {
        FindPeak_162 peak = new FindPeak_162();
        int[] nums = {1,2,1,3,5,6,4};
        int i = peak.solution(nums);
        System.out.println(i);
    }

    private int solution(int[] nums){
//        int n = nums.length;
//        int r = n - 1,l = 0;
//        while(l < r){
//            int m = l + r >> 1;
//            if(nums[m] > nums[m + 1]){
//                r = m;
//            }else
//                l = m + 1;
//        }
//        return l;

        int n = nums.length;
        //先排除特殊情况，即1.只有一个元素，2.峰值出现在第一个或者3.最后一个
        if(n == 1 || nums[0] > nums[1]) return 0;
        if(nums[n - 1] > nums[n - 2]) return n - 1;

        int l = 0, r = n - 2;

        //注意，这里必须有=，因为最终区间会收缩成一个数，那就是峰值
        while(l <= r){
            int mid = l + r >> 1;
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]){
                return mid;
            }else if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else if(nums[mid] < nums[mid - 1]){
                r = mid - 1;
            }
        }

        return -1;
    }
}
