public class RomanToInt_13 {
    public static void main(String[] args) {
        RomanToInt_13 roman = new RomanToInt_13();
//        String s = "MCMXCIV";
        String s = "III";
        int n = roman.romanToInt(s);
        System.out.println(n);

    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        //此处循环时注意越界，i的范围只能在[0,chars.length - 2]，否则+1就会越界
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == 'I' && (chars[i + 1] == 'V' || chars[i + 1] == 'X')) {
                num -= 2;
            }
            if (chars[i] == 'X' && (chars[i + 1] == 'L' || chars[i + 1] == 'C')) {
                num -= 20;
            }
            if (chars[i] == 'C' && (chars[i + 1] == 'D' || chars[i + 1] == 'M')) {
                num -= 200;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'I':
                    num += 1;
                    continue;
                case 'V':
                    num += 5;
                    continue;
                case 'X':
                    num += 10;
                    continue;
                case 'L':
                    num += 50;
                    continue;
                case 'C':
                    num += 100;
                    continue;
                case 'D':
                    num += 500;
                    continue;
                case 'M':
                    num += 1000;
                    continue;
            }
        }
        return num;
    }
}
