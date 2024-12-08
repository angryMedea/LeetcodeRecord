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
                        //如果[i,l]中包含的元素个数大于等于citations[i]
                        //说明citations[i]是一个h指数
                        //因为数组已经排序过了，[i,l]中的元素必然都大于citations[i]
                        //只需要个数再不少于就满足条件了
                        if (l - i + 1 >= citations[i]) {
                            //然后再不断更新最大的h指数
                            max = Math.max(max, citations[i]);
                        }
                    }
                    return max;
                }else
                    // citations[0] > citations.length
                    // 说明所有元素都大于citations[0]，直接返回元素个数
                    return l + 1;
            }else
                return citations.length > citations[0]? 0:1;
        }
    }
}

