import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> res = solution(matrix);
        System.out.println(res);
    }

    public static List<Integer> solution(int[][] matrix){
        int m = matrix[0].length;
        int n = matrix.length;
        List<Integer> res = new ArrayList<>();
        int l = 0, r = m - 1, t = 0, b = n - 1;
        int start = 1, end = m * n;
        // 也可以用res的大小来作为循环条件
//        while(res.size() <= m * n)
        while(start <= end){
            for(int i = l; i <= r;i++){
                res.add(matrix[t][i]);
                start++;
            }
            t++;
            for(int j = t; j <= b;j++){
                res.add(matrix[j][r]);
                start++;
            }
            r--;
            // 遍历到最里层的时候只有两种情况：
            // 1. 中间剩2个数：此时最上层遍历完 t++，t > b，退出循环
            // 2. 中间剩1个数：此时最右层遍历完 r--，l > r，退出循环
            // 如果不及时退出，就会导致重复遍历
            // 如果用res的size作为循环条件，这里就变成
            // if (res.length === size) break
            if(t > b || l > r) break;
            for(int i = r; i >= l;i--){
                res.add(matrix[b][i]);
                start++;
            }
            b--;
            for(int j = b; j >= t;j--){
                res.add(matrix[j][l]);
                start++;
            }
            l++;
        }
        return res;
    }
}
