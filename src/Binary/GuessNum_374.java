package Binary;

/**
 * 通过本题发现一个问题：二分法如何避免出现死循环？
 *
 */

class GuessGame {

    private static final int NUM = 6;

    int guess(int num) {
        if (num == NUM) {
            return 0;
        } else if (num < NUM) {
            return -1;
        }
        return 1;
    }
}


