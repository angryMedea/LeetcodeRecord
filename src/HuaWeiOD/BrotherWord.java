package HuaWeiOD;

import java.util.*;

public class BrotherWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            List<String> list1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list1.add(sc.next());
            }
            String st = sc.next();
            int k = sc.nextInt();
            List<String> list2 = new ArrayList<>();
            for (String s : list1) {
                if (s.length() != st.length() || s.equals(st)) {
                    continue;
                }
                char[] chars1 = st.toCharArray();
                char[] chars2 = s.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                if (Arrays.toString(chars1).equals(Arrays.toString(chars2))) {
                    list2.add(s);
                }
            }
            list2.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            if (list2.size() > 0 && k - 1 >= 0 && k - 1 < list2.size()) {
                System.out.println(list2.size());
                System.out.println(list2.get(k - 1));
            }

        }
    }
}
