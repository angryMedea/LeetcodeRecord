package Amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Input:  newPasswords = ["baacbab", "accdb", "baacba"], oldPasswords = ["abdbc", "ach", "abb"]
 * Output: ["YES", "NO", "YES"]
 * Explanation:
 *
 * Consider the first pair: newPasswords[0] = "baacbab" and oldPasswords = "abdbc". Change "ac" to "bd" at the 3rd and 4th positions, and "b" to "c" at the last position.
 * The answer for this pair is YES.
 *
 * The newPasswords[1] = "accdb" and oldPasswords = "ach".
 * It is not possible to change the character of the new password to "h" which occurs in the old password, so there is no subsequence that matches.
 * The answer for this pair is NO.
 *
 * newPasswords[2] = "baacba" and oldPasswords  = "abb".
 * The answer for this pair is YES.
 *
 * Eventually, we return ["YES", "NO", "YES"].
 * 重点就是类似题目：392. 判断subsequence子序列，会判断了这道题就是简单题
 */
public class checkSimilarPasswords {
    public static List<String> findSimilarities(String[] newPasswords, String[] oldPasswords){
        List<String> results = new ArrayList<>();

        for (int i = 0; i < newPasswords.length; i++) {
            if(canTransToSubsequence(newPasswords[i],oldPasswords[i])){
                results.add("YES");
            }else results.add("NO");
        }
            return results;

    }

    // 方法和392判断子序列一模一样！！
    private static boolean canTransToSubsequence(String newPassword, String oldPassword){
        int i = 0, j = 0;
        while(i < newPassword.length() && j < oldPassword.length()){
            char curNewChar = newPassword.charAt(i);
            char curOldChar = oldPassword.charAt(j);
            if(curNewChar == curOldChar || nextChar(curNewChar) == curOldChar){
                i++;
                j++;
            }else{
                i++;
            }
        }
        return j == oldPassword.length();
    }

    private static char nextChar(char c){
        return c == 'z' ? 'a' : (char)(c + 1);
    }

    public static void main(String[] args) {
        String[] newPwds = {"baacbab", "accdb", "baacba"};
        String[] oldPwds = {"abdbc", "ach", "abb"};

        List<String> res = findSimilarities(newPwds, oldPwds);
        for(String result:res){
            System.out.println(result);
        }

    }
}
