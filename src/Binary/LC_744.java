package Binary;

/**
 * Find Smallest Letter Greater Than Target
 */
public class LC_744 {
    public static void main(String[] args) {
        char[] letters = {'x','x','y','y'};
        char target = 'z';
        LC_744 lc744 = new LC_744();
        System.out.println(lc744.solution(letters, target));
    }

    public char solution(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while(l < r){
            int m = l + (r - l) / 2;
            if(letters[m] > target){
                r = m;
            }else{
                l = m + 1;
            }
        }
        return letters[l] > target? letters[l] : letters[0];
    }
}
