package Binary;

/**
 * 和1283一模一样！！！
 */
public class MinEatingSpeed_857 {
    public static void main(String[] args) {

    }

    public int solution(int[] piles, int h) {
        int max = 1;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int l = 1, r = max;
        while (l < r){
            int m = l + r >> 1;
            if(calTime(piles,m) > h) l = m + 1;
            else r = m;
        }
            return r;
    }

    private int calTime(int[] piles, int k){
        int time = 0;
        for (int pile:piles) {
            time += pile / k + (pile % k != 0? 1 : 0);
        }
        return time;
    }
}


