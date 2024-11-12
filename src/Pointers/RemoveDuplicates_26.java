package Pointers;

/**
 * 删除重复元素，实际上就是将不重复的元素移到数组的左侧。
 */
public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = solution(nums);
        System.out.println(n);
    }

    public static int solution(int[] nums){
        int n = nums.length;
        //设置两个指针
        //j遍历不重复的元素
        //i遍历所有元素
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[j]){
                /**
                 * 注意：这一步会让原数组原地改变
                 * 分两步进行：
                 * 1. j=j+1 完成自增
                 * 2. 改变原数组中的元素
                 *
                 * 当找到不重复的元素后，先把元素放在j的下一位，再完成指针后移
                 */
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
