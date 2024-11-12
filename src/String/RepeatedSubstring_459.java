package String;

/**
 * 字符串匹配的难题：是否能由重复字符串组成
 * KMP算法可解
 */
public class RepeatedSubstring_459 {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        // 注意遍历范围到一半就行，超过一半肯定不存在重复子串
        for(int n = 1; n <= len / 2; n++){
            // 这一步也很关键，如果不能整除，说明不能组成
            if(len % n == 0){
                String subStr = s.substring(0,n);
                StringBuilder sb = new StringBuilder();
                // 直接重复子串来验证是否和原字符串相同
                for (int i = 0; i < len / n; i++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
