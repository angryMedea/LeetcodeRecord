package DynamicProgramming;

/**
 * 考虑每次如何获取最大收益？
 * 第i天的最大收益只需要知道前i天的最低点就可以算出来了
 * 而第i天以前（包括第i天）的最低点和i-1天的最低点有关
 * dp[i] = min(d[i-1],prices[i])
 */
public class MaxProfit_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution(prices));
    }
    public static int solution(int[] prices){
        int len = prices.length;
        if(len <= 1){
            return 0;
        }
        int min = prices[0],max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }
}
