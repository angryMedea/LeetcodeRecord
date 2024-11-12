public class IsValidSudoku_36 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(solution(board));
    }
    /*
    一些问题澄清
    1.为什么要减'0'？
    数字从char直接转换成int，会变成对应的ASCII数字码（ASCII表48-57表示数字0-9），而不是原来的数值。
    解决方法就是当前char数字减'0'：用两个char数字的ASCII码相减，差值就是原来char数值直接对应的int数值。
    2.为什么不是减'0'，而是减'1'？
    若运行了大佬的代码你会发现，减'0'的话会出现ArrayIndexOutOfBoundsException的异常。因为后面的代码将这个num作为了数组的下标。
    本身数组设置的就是9个位置，下标范围是[0~8]，那么遇到数字9作为下标的时候，不就越位了吗，所以就要减1，char转换成int的同时还能解决后面越位的情况。
    所以也可以把数组设置为[10][10]防止出现下标9时越位
    3.box[idx][curNum]是什么意思？
    idx用来确定board[i][j]属于哪个3*3的box，curNum确定是哪一列，相当于把矩阵压缩成数组
    4.总结
    boolean数组的巧妙建立
    第一个[]存放第？行/列/块
    第二个[]存放 相应数字
    结合起来解释就是：第？行/列/块 是否 出现过相应数字
     */
    public static boolean solution(char[][] board){
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }
                int curNum = board[i][j] - '1';
                int idx = i/3*3 + j/3;
                if(row[i][curNum]||col[j][curNum]||box[idx][curNum]){
                    return false;
                }
                row[i][curNum] = col[j][curNum] = box[idx][curNum] = true;
            }
        }
        return true;
    }
}
