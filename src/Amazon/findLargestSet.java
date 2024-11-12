package Amazon;

import java.util.*;

public class findLargestSet {
    public static void main(String[] args) {
        int[] a = {1, 3, 9, 4, 2, 16, 7};
        System.out.println(solution(a));
    }

    public static int solution(int[] perfect){
        List<Integer> set = new ArrayList<>();
        for (int num:perfect){
            set.add(num);
        }
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : perfect) {
//            set.add(num);
//        }

        int result = 0;
        for (int i = 0; i < perfect.length; i++) {
            int count = 0; // Reset count for each iteration
            int num = perfect[i];
            while (set.contains(num) && num != 1) {
                count++;
                num *= num; // Square the current number
                result = Math.max(count, result);
            }
        }
        return result >= 2 ? result : -1;
    }
}
