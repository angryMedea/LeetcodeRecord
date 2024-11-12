package Amazon;

import java.util.HashMap;
import java.util.Map;

public class findMinTrips{
    public static void main(String[] args) {
        int[] packageweight = {1, 8, 5, 8, 5, 1, 1};
        System.out.println(solution(packageweight));
    }

    public static int solution(int[] packageweight) {
        // calculate the times of each unique weight package
        Map<Integer, Integer> map = new HashMap<>();

        for(int weight:packageweight){
            map.put(weight,map.getOrDefault(weight,0) + 1);
        }

        int minTrips = 0;

        for(int weight:map.keySet()){
            int count = map.get(weight);
            if (count == 1) return -1;
            int mod = count % 3;
            if (mod == 0) minTrips += count/3;
            if(mod == 1) minTrips += (count - 4) /3 + 2;
            if (mod == 2) minTrips += (count - 2) /3 + 1;
        }
        return minTrips;
    }
}
