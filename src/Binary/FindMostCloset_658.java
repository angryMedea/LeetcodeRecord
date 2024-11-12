package Binary;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */
public class FindMostCloset_658 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        int k = 4, x = 2;
        System.out.println(new FindMostCloset_658().solution1(arr, k, x));
        System.out.println(new FindMostCloset_658().solution2(arr, k, x));

    }

    public List<Integer> solution1(int[] arr, int k, int x) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int removeNums = size - k;
        while (removeNums > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removeNums--;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    // 先用二分法找到最接近x的值，在双指针确定范围
    public List<Integer> solution2(int[] arr, int k, int x){
    // 一开始还是常规二分
        int len = arr.length, l = 0, r = len - 1;
        while(l < r){
            // 因为arr是排序之后的，这里要寻找偏大值，就是接近x的右边界的值
            int mid = l + r + 1 >>> 1;
            if(arr[mid] > x) r = mid - 1;
            else l = mid;
        }
        // 需要把找到的这个最接近x但是小于x的值，和
        r = r + 1 < len && Math.abs(arr[r + 1] - x) < Math.abs(arr[r] - x)? r + 1:r;

        //i和j分别是最后结果区间的左右边界，注意是左开右开的区间
        //就是说不包括i和j
        int i = r - 1, j = r + 1;

        // 这里区间边界动态扩展，一定要注意条件！！
        // 由于是左开右开，i可以取到-1，j可以取到len
        while(j - i - 1 < k){
            if(j < len && i >= 0){
                if (Math.abs(arr[j] - x) < Math.abs(arr[i] - x)){
                    j++;
                }else i--;
            }else if(i >= 0){
                i--;
            }else{
                j++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int m = i + 1; m < j; m++) {
            list.add(arr[m]);
        }

        return list;
    }
}
