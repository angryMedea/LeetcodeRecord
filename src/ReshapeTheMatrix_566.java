import java.util.Arrays;

public class ReshapeTheMatrix_566 {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        solution(nums,r,c);
    }

    public static int[][] solution(int[][] nums,int r,int c){
        int or = nums.length;
        int oc = nums[0].length;
        int[][] ans = new int[r][c];
        if(or * oc!= r * c) return nums;
        for(int i = 0, idx = 0; i < or; i++){
            for (int j = 0; j < oc; j++, idx++) {
                ans[idx/c][idx%c] = nums[i][j];
            }
        }
        return ans;
    }
}
