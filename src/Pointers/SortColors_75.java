package Pointers;

import java.util.Arrays;

/**
 * 荷兰国旗问题，以n为划分值，原地把>n和<n的元素划分为两个区间
 * 存在一个通用的解法
 */
public class SortColors_75 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,1,1,0,1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static int[] solution(int[] nums, int n) {
        //方法一：冒泡排序
//        int n = nums.length;
//        for(int i=0;i<n-1;i++){//控制比较轮次，一共 n-1 趟
//            for(int j=0;j<n-1-i;j++){//控制两个挨着的元素进行比较
//                if(nums[j] >= nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }

        //方法二：油漆法（没看懂）
//            int n0 = 0, n1 = 0;
//            for(int i = 0; i < nums.length; i++){
//                int num = nums[i];
//                nums[i] = 2;
//                if(num < 2){
//                    nums[n1++] = 1;
//                }
//                if(num < 1){
//                    nums[n0++] = 0;
//                }
//            }
//            return nums;

        //方法三：多指针法，此时划分值为1，相当于要找出<1，=1和>1的区间
        // p1指针为<1区间的右边界，p2为>1的左边界，index为当前数组所指向的元素
        int p1 = 0, p2 = nums.length - 1, index = 0;
        //退出循环的条件是index和>1的右边界重合，表示所有元素都已经遍历完了
        while (index <= p2) {
            if (nums[index] < n) {
            //当前元素=0，nums[index]和nums[p1]进行交换
            //p1后移1位，<1区间扩大1位
            //index后移1位继续遍历
            //注意：当元素<1时，index和p1同步后移，除非index和p2交换，
                // 否则p1都是检查过的元素，所以index可以后移继续遍历
                swap(nums,index++,p1++);
            }
            else if (nums[index] > n) {
            //当前元素=2，nums[index]和nums[p2]进行交换，并且p2前移一位，>1区间扩大1位
            //注意，此时index不变，因为nums[p2]是交换过来的元素，index要重新遍历一遍检查大小
                swap(nums,index,p2--);
            }
            else {
                //元素=1时，不用交换，直接移动index指针
                index ++;
            }
        }
        return nums;
    }

    public static int[] swap(int[] nums, int index, int p){
        int temp = nums[index];
        nums[index] = nums[p];
        nums[p] = temp;
        return nums;
    }

    public static void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                //in case there is an extra 0 in the progress,e.g nums[9] == 1,nums[8] == 0, so index has to decrease to
                // make room for extra 0 in the following progress
                index--;
            }
            index++;
        }
    }

}
