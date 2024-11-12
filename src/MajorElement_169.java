import java.util.HashMap;
import java.util.Map;

public class MajorElement_169 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,4,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length/2){
                max = entry.getKey();
                break;
            }
        }
        return max;
    }
}
