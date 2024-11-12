package Pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    /**
     *
     *   贪心策略:
     *     1.按照左边界升序排序
     *     2.当intervals[i][0]<=intervals[i-1][1]时,说明能合并,更新intervals[i][1]=max(intervals[i][1],intervals[i-1][1])
     *     3.当intervals[i][0]>intervals[i-1][1]时,区间不重叠,将前面区间加入结果,更新新的左边界
     *     4.理论上最后一个结果不会加入,手动加入即可
     *
     * @param intervals
     * @return
     */
    static int[][] merge(int[][] intervals){
        List<int[]> list = new ArrayList<>();
        //java8 new features + lambda expressions
        Arrays.sort(intervals,(o1, o2) -> o1[0] - o2[0]);
        int len = intervals.length;
        //the original point of start
        int start = intervals[0][0];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] > intervals[i - 1][1]){
                list.add(new int[]{start,intervals[i - 1][1]});
                //renew the start point of the interval
                start = intervals[i][0];
            }else{
                intervals[i][1] = Math.max(intervals[i - 1][1],intervals[i][1]);
            }
        }
        //add the last group of the array
        list.add(new int[]{start, intervals[len - 1][1]});
        //transfer the list to array
        return list.toArray(new int[list.size()][]);
    }
}
