package Binary;

/**
 * 自己稀里糊涂的解法，但是能通过
 */
public class Sqrt_69_1 {
    public static void main(String[] args) {
        System.out.println(new Sqrt_69_1().mySqrt(1024));
    }
        public int mySqrt(int x) {
            if (x == 0) {
                return 0;
            }
            if (x == 1) {
                return 1;
            }

            int y = 1;
            while(x >= y){
                if(x/y > y){
                    y ++;
                }else if(x/y == y){
                    return y;
                }else{
                    return x/y;
                }
            }
            return y;
        }
    }

