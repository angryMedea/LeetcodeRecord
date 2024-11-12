package Binary;

public class GussNum_374 extends GuessGame {

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // int mid = left + (right - left + 1) / 2;
            int mid = (left + right + 1) >>> 1;
            int guessNum = guess(mid);
            if (guessNum == -1) {
                // 中位数比猜的数大，因此比中位数大的数包括中位数都不是目标元素
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 最后剩下的数一定是所求，无需后处理
        return left;
    }


    public static void main(String[] args) {
        GussNum_374 solution = new GussNum_374();
        int n = 10;
        int guessNumber = solution.guessNumber(n);
        System.out.println(guessNumber);
    }
}
