package Amazon;

public class makePowerNonDescreasing {
    public static void main(String[] args) {
//        int[] power = {3,4,1,6,2};
        int[] power = {3,4,1,2,5,0};
        System.out.println(solution(power));
    }

    public static int solution(int[] power){
        int l = power.length;
        int count = 0;
        for (int i = 1; i < l; i++) {
            if (power[i] < power[i - 1]) {
                count += power[i - 1] - power[i];
            }
        }
        return count;
    }
}
