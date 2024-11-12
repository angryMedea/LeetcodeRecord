package Greedy;

/**
 * 贪心思路：累加最小数的下一个index就是答案
 * 人话：亏空最严重的一个数必须放在最后一步走，等前面剩余补给的救助
 */
public class GasStation_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int[] arr = new int[len];
        int ans = 0;
        int sum = 0;
        for(int i = 0; i < len; i++){
            arr[i] = gas[i] - cost[i];
            sum += arr[i];
        }

        if(sum >= 0){
            int curSum = 0;
            for(int i = 0; i < len; i++){
                curSum += arr[i];
                if(curSum < 0){
                    ans = (i + 1) % len;
                    // 归零是为了保证累加的数是最后一个负数
                    // 这样就能让累加的亏空最多
                    curSum = 0;
                }
            }
        }else ans = -1;
        return ans;
    }
}
