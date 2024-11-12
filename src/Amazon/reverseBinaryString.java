package Amazon;

public class reverseBinaryString {
    public static void main(String[] args) {
        String s = "00110101";
        System.out.println(solution(s));
    }

    public static int solution(String s){
            int n = s.length();

            // Create a reversed string
            StringBuilder rev = new StringBuilder(s);
            rev.reverse();

            // find the longest prefix of the reversed string
        //that is also a substring of the original string
            int lp = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == rev.charAt(lp)) {
                    lp++;
                }
            }

            return n - lp;
        }
    }

