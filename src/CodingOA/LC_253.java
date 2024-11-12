package CodingOA;

import java.util.*;

/**
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi]，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 *
 * 示例 1:
 * 输入: [[0, 30],[5, 10],[15, 20]]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [[7,10],[2,4]]
 * 输出: 1
 *
 * 思路：【最小堆】
 *      1. 为了让会议室数量最少，尽量让会议在同一个会议室进行
 *         什么情况下会议不冲突可以使用同一个会议室：上一个会议的结束时间，早于下一个会议的开始时间
 *      2. 就是说需要同时比较会议的开始时间和结束时间
 *      3. 为了按照时间遍历，需要对intervals数组进行排序，把更早开始的放在前面【排序开始时间-利用集合自带方法】
 *      3. 然后再根据结束时间进行排序，把最早结束的时间放在前面【排序结束时间-最小堆】
 *      4. 如果最早的那个结束时间早于下一个会议的开始时间，说明可以使用同一间会议室，不用多加，弹出队列
 *      5. 将下一个会议加入队列
 *      6. 遍历结束后，队列中剩余的元素数量，就是需要的最少会议室的数量
 *      【双指针】
 *      1. 分别储存开始时间和结束时间并排序
 *      2. 逐个进行比较：上一个会议的结束时间，早于下一个会议的开始时间，就count--
 *
 */
public class LC_253 {
    public int minMeetingRooms1(List<List<Integer>> intervals){
        //减枝
        if(intervals == null || intervals.size() == 0) return 0;
        Collections.sort(intervals, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(intervals.get(0).get(1));
        for (int i = 0; i < intervals.size(); i++) {
            if(intervals.get(i).get(0) >= q.peek()){
                q.poll();
            }
            q.offer(intervals.get(i).get(1));
        }
        return q.size();
    }

    public int solution2(List<List<Integer>> intervals){
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }

        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals.get(i).get(0);
            endTimes[i] = intervals.get(i).get(1);
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int startPointer = 0, endPointer = 0;
        // roomsRequired 是动态变化的：它在每次处理会议的开始和结束时都会发生变化
        // 表示的是某一时间段，所需要的会议室数量，如果不重叠，就只需要一间会议室
        int roomsRequired = 0;

        // 表示的是完成所有会议所需要的最小会议室数量，是所有时间段的
        int minRoomsRequired = 0;

        while (startPointer < n) {
            if (startTimes[startPointer] >= endTimes[endPointer]) {
                roomsRequired--;
                endPointer++;
            }

            roomsRequired++;
            startPointer++;

            // 更新最少会议室的需求，是两者中的最大值，因为要包含所有时间段
            minRoomsRequired = Math.max(minRoomsRequired, roomsRequired);
        }

        return minRoomsRequired;
    }

}
