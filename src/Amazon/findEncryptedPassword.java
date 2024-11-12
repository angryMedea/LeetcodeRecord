package Amazon;

import java.util.Arrays;

public class findEncryptedPassword {
    public static void main(String[] args) {
        String password = "rsqqsr";
        System.out.println(solution(password));
    }

    public static String solution(String password){
        int l = password.length();
        String p1 = password.substring(0,l/2);
        char[] chars1 = p1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = new char[l];
        for (int i = 0; i < l/2; i++) {
            chars2[i] = chars1[i];
        }
        for (int i = l - 1; i > l/2 ; i--) {
            chars2[i] = chars1[l - i - 1];
        }

        chars2[l/2] = l % 2 == 0? chars1[l/2 - 1]:password.charAt(l/2);
        return new String(chars2);
    }
}
