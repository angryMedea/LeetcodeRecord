package Binary;

/**
 * 其实就是求最大值，第一种方法：简单粗暴直接遍历
 */
public class PeakIndexInMountainArray_852_1 {
    public static void main(String[] args) {
        int[] arr = {3,5,7,8,12,44,66,87,23,12};
        PeakIndexInMountainArray_852_1 mountainArray = new PeakIndexInMountainArray_852_1();
        System.out.println(mountainArray.solution(arr));
    }

    public int solution(int[] arr) {
        int n = arr.length - 1;
        int ans = -1;
//        while(left < right){
//            mid = left + (right - left)/2;
//            //此处，一旦mid=0,下标就可能为-1，产生越界风险
//            if(arr[mid - 1] < arr[mid]){
//                if(arr[mid + 1] < arr[mid]){
//                    return mid;
//                }else
//                    left = mid + 1;
//            }else
//                right = mid - 1;
//        }
//        return left;
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i + 1]){
                    ans = i;
                    break;
                }
            }
            return ans;
        }

    }


