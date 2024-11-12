package StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class topKFrequent_347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(new topKFrequent_347().solution(nums, k)));
    }

    public int[] solution(int[] nums,int k){
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue<>(
//                new Comparator<Integer>()
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return map.get(o1) - map.get(o2);
//            }
                //lambda expression
                (o1,o2) -> map.get(o1) - map.get(o2)
        );
        for(int key:map.keySet()){
            if (pq.size()<k)
                pq.offer(key);
            else if (map.get(key) > map.get(pq.peek())) {
                pq.poll();
                pq.offer(key);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
        // 遍历数组，维护一个大小为 k 的小根堆：
        // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
        counter.forEach((num, cnt) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counter.get(pq.peek()) < cnt) {
                pq.poll();
                pq.offer(num);
            }
        });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num: pq) {
            res[idx++] = num;
        }
        return res;
    }
}
