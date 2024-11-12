package Binary;

/**
 * 第二种方法：二分法
 */
public class PeakIndexInMountainArray_852_2 {
    public static void main(String[] args) {
        int[] arr = {3,5,7,8,12,44,66,87,23,12};
        PeakIndexInMountainArray_852_2 mountainArray = new PeakIndexInMountainArray_852_2();
        System.out.println(mountainArray.solution(arr));
    }

    public int solution(int[] arr) {
        int left = 1;
        int right = arr.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if (arr[mid] > arr[mid + 1]){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
        }
    }


