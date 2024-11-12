package Amazon;

public class getLongestMatch {
    public static void main(String[] args) {
        String text = "hackerrank";
        String regex = "ac*ke";
//        String text = "tommorrow";
//        String regex = "r*wo";
        int result = getLongestMatch(text, regex);
        System.out.println("The length of the longest matching substring is: " + result); // Output: 6
    }

    public static int getLongestMatch(String text, String regex) {
        int l = text.length();
        int i = 0;
        int j = l - 1;
        int star = -1;

        while (i < l) {
            if (text.charAt(i) == regex.charAt(0)) break;
            i++;
        }
        while (j >= 0) {
            if (text.charAt(j) == regex.charAt(regex.length() - 1)) break;
            j--;
        }

        for (int k = 0; k < regex.length(); k++) {
            if (regex.charAt(k) == '*'){
                star = k;
                break;
            }
        }
        String newText = "";
        if (i < j) {
            newText = text.substring(i, j + 1);
            if (newText.substring(0,star).equals(regex.substring(0,star))){
                if (newText.endsWith(regex.substring(star + 1))){
                    return newText.length();
                }else if (star + 1 == regex.length())
                    return star;
            }else
                return -1;
        }

        if (star == 0){
            newText = text.substring(j);
            if (newText.equals(regex.substring(star + 1))) return text.length();
        }

        if (star == regex.length() - 1){
            newText = text.substring(i,regex.length());
            if (newText.equals(regex.substring(0,star))) return text.length() - i;
        }

        return -1;
    }
}
