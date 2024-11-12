package String;

/**
 * 简单题，但是暴力解法都有难度
 */
public class FindTheOccurrence_28 {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 暴力解法：注意第一个指针i是要依次遍历i后面len2范围的字符串，遍历完了之后再移动
     *          不能直接和j指针进行对比，否则会漏掉相等的前缀
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();

        for (int i = 0; i + len2 < len1; i++) {
            boolean flag = true;
            for (int j = 0; j < len2; j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }

    /**
     * KMP算法：在文本串中找模式串
     * @param ss 文本串(string)
     * @param pp 模式串(pattern)
     * @return
     */
    public static int kmp(String ss, String pp){
        int n = ss.length(), m = pp.length();
        // 文本串和模式串前面都加空格，使其下标从1开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建next数组，数组长度为模式串的长度
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造从i=2开始】
        for(int i = 2, j = 0; i <= m; i++){
            // 如果匹配不成功
            while (j > 0 && p[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让j++
            if(p[i] == p[j+1]) j++;
            // 再更新next[i]，结束本次循环，i++
            next[i] = j;
        }

        //匹配过程，i=1,j=0开始，i小于等于文本串的长度【匹配从i=1开始】
        for (int i = 1,j = 0; i <= n ; i++) {
            while(j >0 && s[i] != p[j+1]) j = next[j];
            if (s[i] == p[j+1]) j++;
            if (j == m) return i - m;
        }
        return -1;
    }
}
