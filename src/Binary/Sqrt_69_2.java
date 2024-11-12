package Binary;

/**
 * 整数x的平方根一定小于或等于x
 * 除0之外的所有整数的平方根都大于或等于1
 * 整数x的平方根一定是在1到x的范围内，取这个范围内的中间数字mid，并判断mid的平方是否小于或等于x，
 * 如果mid的平方小于x
 * 那么接着判断(mid+1)的平方是否大于x，如果(mid+1)的平方大于x，那么mid就是x的平方根
 * 如果mid的平方小于x并且(mid+1)的平方小于x，
 * 那么x的平方根比mid大，接下来搜索从mid+1到x的范围
 * 如果mid的平方大于x，
 * 则x的平方根小于mid，接下来搜索1到mid-1的范围
 * 然后在相应的范围内重复这个过程，总是取出位于范围中间的mid
 */

public class Sqrt_69_2 {
    public static void main(String[] args) {

        System.out.println(new Sqrt_69_2().mySqrt(1));
    }

    public int mySqrt(int x) {
        int left = 1, right = x, mid;
        /**
         * 注意！
         *  while()的搜素区间必须是 小于等于 而不能是 小于
         *  若 left < right，则当 x=1 时，会直接终止搜索，跳出循环
         *  则 1 的平方根返回错误的值 0
         */
        while (left <= right){
            mid = left + ((right - left) >> 1);
            if (mid <= x/mid){
                if ((mid + 1) > x/(mid + 1)){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}

