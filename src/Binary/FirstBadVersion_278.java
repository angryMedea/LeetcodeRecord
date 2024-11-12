package Binary;

/**
 * 经典找满足条件的第一个值的例题！！
 * mid=l+r>>>1 向偏小值取整 找到满足条件的第一个mid
 */
public class FirstBadVersion_278 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        int target = 7;
        int idx = binarySearch(array,target);
        System.out.println(idx);
    }

    public static int binarySearch(int[] a,int t){
        int l = 0,r = a.length -1,m;
        while (l < r){
            long tmp = (long)l + r >> 1;
            m = (int)tmp;
            if (a[m] == t){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return r;
    }
}


