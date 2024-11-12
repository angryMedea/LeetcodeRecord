package Pointers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertIntervals_57 {
    public static void main(String[] args) {

    }

    static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n < 1) return new int[][]{newInterval};

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]){
//              intervals[i][1] = Math.max(intervals[i][1],newInterval[1]);
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }else{
                list.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        list.add(new int[]{newInterval[0],newInterval[1]});
        list.sort(Comparator.comparingInt(arr -> arr[0]));
        //specify the elements that can be added to the list when it is changed into array
        //put a 0 in new int[0][] means initialize a two dimensional array with flexible room
        // so that it will not print null in the result output.
        return list.toArray(new int[0][]);
    }
}
