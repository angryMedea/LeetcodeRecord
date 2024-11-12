package String;

/**
 * 题意：每2k个字符，反转前k个字符，不够k的话，就全部反转
 * 双指针（LC344解法） + 注意遍历指针跳动的条件
 */
public class ReverseString_541 {
    public String reverseStr(String s, int k) {
        int len = s.length();
        // 注意必须先转换成char数组，否则后面无法交换
        char[] arr = s.toCharArray();

        // 注意这里不能直接写成2k，会报错，java中必须有明确的运算符
        for(int i = 0;i < len;i += 2*k){
            // 画图确定条件！！
            if(i + k <= len){
                reverse(arr,i,i+k-1);
            }else
                reverse(arr,i,len-1);
        }
        return new String(arr);
    }

    void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
