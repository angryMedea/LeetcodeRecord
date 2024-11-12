/**
 * string不能转化成int，可能溢出
 * 两个加数的字符串长度可能不同，要注意补位
 * 最后进位carry不为0的话，需要计算进位
 * 拼接的顺序是向后拼接，返回时需要把res反转
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int i = a.length() - 1;//标记遍历位置
        int j = b.length() - 1;
        int carry = 0;//进位
        while(i >= 0 || j >= 0){
            int digitA = i >= 0? a.charAt(i) - '0': 0;
            int digitB = j >= 0? b.charAt(i) - '0': 0;
            int sum = digitA + digitB + carry;//当前位置相加的结果
            carry = sum >= 2 ? 1:0;//是否有进位
            sum = sum >=2? sum-2:sum;//去除进位后的数字
            res.append(sum);
            i--;
            j--;
        }
        if(carry != 0) res.append(carry);//最后的进位也要保留在结果中
        return res.reverse().toString();
    }
}
