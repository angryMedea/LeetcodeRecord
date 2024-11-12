import java.util.Arrays;

/**
 * 初始化一个 n×n 大小的矩阵 res，然后模拟整个向内环绕的填入过程：

 * 定义当前左右上下边界 l,r,t,b，初始值 num = 1，迭代终止值 tar = n * n；
 * 当 num <= tar 时，始终按照 从左到右 从上到下 从右到左 从下到上 填入顺序循环，每次填入后：
 * 执行 num += 1：得到下一个需要填入的数字；
 * 更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
 * 使用num <= tar而不是l < r || t < b作为迭代条件，是为了解决当n为奇数时，矩阵中心数字无法在迭代过程中被填充的问题。
 * 最终返回 res 即可。
 * Time and Space complexity are both O(n*n)
 */
public class SpiralMatrix_59 {
    public static void main(String[] args) {
        int n = 4;
        SpiralMatrix_59 matrix = new SpiralMatrix_59();
        int[][] res = matrix.generateMatrix(n);
        System.out.println(Arrays.deepToString(res));
    }
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int num = 1, tar = n * n;
            int l = 0, r = n - 1, t = 0, b = n - 1;
            /**
             * 在填充数组时，一定要注意究竟是哪个下标不变，是组内还是组外！
             */
            while(num <= tar){
                for(int i = l; i <= r; i++){
                    res[t][i] = num++;// t不变，从左到右填充
                }
                t++;
                for(int j = t; j <= b; j++){
                    res[j][r] = num++;// r不变，从上到下填充，注意j和r的顺序！！！
                }
                r--;
                for(int i = r; i >= l; i--){
                    res[b][i] = num++;// b不变，从右往左填充
                }
                b--;
                for(int j = b; j >= t; j--){
                    res[j][l] = num++;// l不变，从下往上填充，注意j和l的顺序！
                }
                l++;
            }
            return res;
        }
}
