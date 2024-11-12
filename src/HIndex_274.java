import java.util.Arrays;

public class HIndex_274 {
    public static void main(String[] args) {
        int[] c = {4,4,0,0};
        System.out.println(new Solution().hIndex(c));
    }

    static class Solution {
        public int hIndex(int[] citations) {
            if(citations.length > 1){
                int l = citations.length - 1;
                Arrays.sort(citations);
                int max = 0;
                if (citations[0] < l + 1) {
                    for (int i = 0; i <= l; i++) {
                        if (l - i + 1 >= citations[i]) {
                            max = Math.max(max, citations[i]);
                        }
                    }
                    return max;
                }else
                    return l + 1;
            }else
                return citations.length > citations[0]? 0:1;
        }
    }
}

