package Amazon;

public class countSimilarSubstrings {
    public static void main(String[] args) {
        String text = "monomono";
        String key = "mon";
        System.out.println(solve(text, key));
    }

    public static int solve(String text, String key){
        int count = 0;
        int n = text.length();
        int m = key.length();

        for (int i = 0; i <= n - m; i++) {
            String substring = text.substring(i, i + m);
            if (isSimilar(substring, key)) {
                count++;
            }
        }

        return count;

    }

    private static boolean isSimilar(String s, String k) {
        int differences = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != k.charAt(i)) {
                differences++;
                if (differences > 2) {
                    return false; // More than one difference found, not similar
                }
            }
        }
        return differences <= 2;
    }
}
