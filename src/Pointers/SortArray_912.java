package Pointers;

import java.util.Arrays;

public class SortArray_912 {
    public static void main(String[] args) {
        int[] nums = {1,22,3,42,11,23};
//        int[] ints = sortArray(nums);
//        int[] ints = mergeSort1(nums, 0, nums.length - 1);
//        System.out.println(Arrays.toString(ints));
        mergeSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 插入排序：稳定排序，在接近有序的情况下，表现优异
    public static int[] sortArray(int[] nums) {
        int len = nums.length;
        // 循环不变量：将 nums[i] 插入到区间 [0, i) 使之成为有序数组
        for (int i = 1; i < len; i++) {
            // 先暂存这个元素，然后之前元素逐个后移，留出空位
            int temp = nums[i];
            int j = i;
            // 注意边界 j > 0
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            //把当前遍历到的元素temp插入正确的位置j
            //此时nums[j-1]<temp，即nums[j-1]<nums[j]，符合升序
            nums[j] = temp;
        }
        return nums;
    }

    //归并排序：分而治之，递归
    public static int[] mergeSort1(int[] nums, int left, int right){
        //递归退出条件
        //如果左指针大于右指针，就退出循环
        //经过左右拆分，数组元素形成单个元素的树
        if(left >=right){
            return nums;
        }
        //数组中的中位数
        int mid = (right+left)/2;
        //数组左拆分
        mergeSort1(nums, left, mid);
        //数组右拆分
        mergeSort1(nums, mid+1, right);
        //数组合并，将单个元素进行合并
        return merge1(nums, left, mid, right);
    }

    public static int[] merge1(int[] nums, int left, int mid, int right){
        //定义一个临时数组，存储排序好的元素
        int[] temp = new int[right-left+1];
        //左排序的元素数组的左指针
        int i = left;
        //右排序的元素数组的左指针
        int j = mid+1;
        //定义一个指向临时数组的左指针
        int t = 0;
        //循环判断条件
        //左数组到mid，右数组到right
        //左右数组都有元素的时候，进行比较
        while(i<=mid&&j<=right){
            //取左右数组中较小的元素，填入临时数组中
            //并将较小元素所在数组的左指针和临时数组的左指针都一起右移
            if(nums[i]<=nums[j]){
                temp[t] = nums[i];
                i++;
            }else{
                temp[t] = nums[j];
                j++;
            }
            t++;
        }
        //当左右数组其中一个数组没有元素的时候
        //如果左数组中还有剩余元素，就将剩余元素全部加入到临时数组中
        while(i<=mid){
            temp[t]=nums[i];
            t++;
            i++;
        }
        //如果有数组中还有元素，就将剩余元素全部加入到临时数组中
        while(j<=right){
            temp[t] = nums[j];
            t++;
            j++;
        }
        //将临时数组的元素复制到原数组中去
        for(int k = 0; k<temp.length;k++){
            //特别注意这便nums数组起始位置要从 k+left开始
            //原因:在原地复制右数组的时候，起始位置要加left
            nums[left+k]=temp[k];
        }
        //返回原数组
        return nums;
    }


        public static void mergeSort2(int []arr){
            int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
            sort(arr,0,arr.length-1,temp);
        }
        private static void sort(int[] arr,int left,int right,int []temp){
            if(left<right){
                int mid = (left+right)/2;
                sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
                sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
                merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
            }
        }
        private static void merge(int[] arr,int left,int mid,int right,int[] temp){
            int i = left;//左序列指针
            int j = mid+1;//右序列指针
            int t = 0;//临时数组指针
            while (i<=mid && j<=right){
                if(arr[i]<=arr[j]){
                    temp[t++] = arr[i++];
                }else {
                    temp[t++] = arr[j++];
                }
            }
            while(i<=mid){//将左边剩余元素填充进temp中
                temp[t++] = arr[i++];
            }
            while(j<=right){//将右序列剩余元素填充进temp中
                temp[t++] = arr[j++];
            }
            t = 0;
            //将temp中的元素全部拷贝到原数组中
            while(left <= right){
                arr[left++] = temp[t++];
            }
        }
}
