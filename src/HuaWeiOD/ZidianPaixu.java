package HuaWeiOD;

import java.util.*;

public class ZidianPaixu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        Set<String> set = new TreeSet<String>();
//        while(in.hasNextLine()){
//            set.add(in.nextLine());
//        }
//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = in.next();
        }
        Arrays.sort(strings);
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
