package Amazon;

import java.util.ArrayList;
import java.util.List;

public class maxNumberOfBalancedShipments {
    public static void main(String[] args) {
        int[] case1 = {1,2};
        int[] case2 = {8, 5, 4, 7, 2};
        int[] case3 = {4, 3, 6, 5, 3, 4, 7, 1};
        int[] case4 = {1,2,3,4,4};
        int[] case5 = {5, 4, 3, 2, 1, 2, 3, 4, 5};
        System.out.println(solution(case1));

    }

    public static int solution(int[] weights) {
        int l = weights.length;
        int p = 0, q = 1;
        List<int[]> list = new ArrayList<>();
        while (p < q && q < l) {
            int m = weights[p];
            int n = weights[q];
            if (n < m) {
                list.add(new int[]{m, n});
                p += 2;
                q += 2;
            } else {
                p++;
                q++;
            }
        }
        if (list.size() != 0) {
            int[] last = list.get(list.size() - 1);
            if (last[last.length - 1] != weights[l - 1]) {
                return 0;
            } else
                return list.size();
        }else
            return 0;
    }
}
