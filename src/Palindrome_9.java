public class Palindrome_9 {
    public static void main(String[] args) {
        Palindrome_9 palindrome = new Palindrome_9();
        int x = 1234321;
        boolean b = palindrome.isPalindrome(x);
        System.out.println(b);
    }

    public boolean isPalindrome(int x) {
        /**
         * 第一种方法：将整个x进行反转，然后和原数进行比较看是否相等
         * 当x数值很大的时候，会有溢出风险
         */
        // if(x < 0) return false;

        // int r = 0;
        // int num = x;
        // while(num != 0){
        //     r = r * 10 + num % 10;
        //     num /= 10;
        // }
        // return r == x;
        /**
         * 第二种方法：仅反转后面的一半数字，当原数字等于or小于反转后的数字时，跳出循环
         * e.g x = 1221,r = 12 时跳出循环，此时 x == r
         *     x = 12321,r = 123 时跳出循环，此时 x == r/10
         */
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;

        int r = 0;
        while(x > r){
            r = r * 10 + x % 10;
            x /= 10;
        }

        return x == r || x == r / 10;
    }
}
