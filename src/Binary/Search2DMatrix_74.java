package Binary;

public class Search2DMatrix_74 {
    public static void main(String[] args) {
        int[][] matrix = {{1,1}};
        int target = 13;
        System.out.println(
                new Search2DMatrix_74().searchMatrix(matrix,target)
        );

    }


        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int l = 0, r = m * n - 1;
            while(l < r){
                int mid = l + r >> 1;
                if (matrix[mid/n][mid%n] < target){
                    l = mid + 1;
                }else
                    r = mid - 1;
            }
            return matrix[r / n][r % n] == target;
        }
}


