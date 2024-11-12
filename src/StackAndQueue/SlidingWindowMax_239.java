package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax_239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(solution(nums, 3));
    }

    static int[] solution(int[] nums,int k){
        // 剪枝
        if(nums == null || nums.length < 2) return nums;
        int[] res = new int[nums.length - k + 1];
        // 双端队列，两边都能进出
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            // 1. 入队，保证从大到小，如果前面的数更小，就依次弹出，直到队列前面的数
            // 也就是 queue.peekLast() 比新加入的数更大
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // queue为空时首次添加当前值对应的下标
            queue.addLast(i);
            // 判断当前队列中的对首的下标是否在k的范围内，不在的话要弹出
            if(i - queue.peek() >= k){
                queue.poll();
            }
            // 当窗口长度为k时，保存当前窗口中的最大值，也就是队首下标对应的元素
            if(i >= k - 1){
                res[i- (k - 1)] = nums[queue.peek()];
            }
        }
        return res;

        //     if (nums == null || nums.length == 0 || k == 0) return new int[0];

        //     int[] result = new int[nums.length - k + 1];

        //     for (int i = 0; i <= nums.length - k; i++) {
        //         int max = Integer.MIN_VALUE;
        //         for (int j = i; j < i + k; j++) {
        //             max = Math.max(max, nums[j]);
        //         }
        //         result[i] = max;
        //     }

        //     return result;

    }
}
