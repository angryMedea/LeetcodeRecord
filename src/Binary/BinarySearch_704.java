package Binary;

/**
 * 二分法模版题目
 */

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] array = {12,33,43,55,67,71,88,94,107,223,332,341,532};
        int target = 332;
        int idx = binarySearch(array,target);
        System.out.println(idx);
    }

    public static int binarySearch(int[] a,int t){
        int l = 0,r = a.length -1,m;
        while (l <= r){
            m = (l + r)/2;
            if (a[m] == t){
                return m;
            }else if (a[m] > t){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }
}


