package String;

public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        // trim()删除字符串首尾的所有空白字符
        String l = s.trim();
        // 将字符串拆成string数组
        String[] strings = l.split(" ");
        int n = strings.length;
        StringBuilder str = new StringBuilder();
        for(int i = n-1; i >= 0; i--){
            if(i == 0){
                str = str.append(strings[i]);
            }else if (strings[i].equals("")){
                // 必须有这一步，并不是多余的
                continue;
            }else {
                str = str.append(strings[i]).append(" ");
            }
        }

        return str.toString();
    }
}
