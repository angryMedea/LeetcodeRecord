package Amazon;

import java.util.PriorityQueue;

public class getMaxRewardPoints {
    public static void main(String[] args) {
    int[] reward = {5,5,5};
        System.out.println(solve(reward));
    }

    public static long solve(int[] reward){
        PriorityQueue<Integer> nums = new PriorityQueue<>();
        for (int i : reward) {
            nums.offer(-i);
        }
        int ans = -nums.poll();
        int i = 1;
        while (!nums.isEmpty()) {
            int temp = -nums.poll();
            if (temp - i <= 0) {
                break;
            }
            ans += temp - i;
            i++;
        }
        return ans;
    }
}
