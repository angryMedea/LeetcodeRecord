package DynamicProgramming;

/**
 * 递推公式是如何推导出来的？
 * 无论上多少台阶，都可以归纳为在登上这节台阶之前，最后一步是走1步还是2步
 * 假设f(n)是走n步台阶的所有方法，f(n-1)是走n-1步台阶的方法，f(n-2)是走n-2步台阶的方法
 * 无论之前是走n-1还是n-2阶，最后一步都只对应一种方法：走了n-1阶只能选1阶，走了n-2阶的只能选2阶
 * 因此走n阶的方法 f(n) = f(n-1) * 1 + f(n-2) * 1 = f(n-1) + f(n-2)
 * 可能会问：为什么走了n-2阶的选2阶，不能对应2阶两种方法？
 *          因为走2阶只能是 1+1 or 2
 *          如果选1+1，就和前面走n-1阶中包含的方法一样了，所以只剩走2阶这个方法
 */
public class ClimbingStairs_70 {
    public int climbStairs(int n) {
        if(n <= 1) return 1;//先排除edge case
        //1. dp数组储存爬楼梯的所有不同方法，下标i表示阶数
        //这里为了避免hard code,引入dp[0],多占一位
        int[] dp = new int[n + 1];
        //3. 初始化dp，dp[0]的含义是0阶
        dp[0] = 1;
        dp[1] = 1;
        //4. 递归顺序：从前往后
        for(int i = 2; i <= n; i++){
            //2. 递推公式
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
