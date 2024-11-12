package Binary;

import java.util.Arrays;

public class AbsoluteSumDiff_1818 {
    public static void main(String[] args) {
        AbsoluteSumDiff_1818 sumDiff = new AbsoluteSumDiff_1818();
        int[] n1 = {3};
        int[] n2 = {5};
        int i = sumDiff.minAbsoluteSumDiff(n1, n2);
        System.out.println(i);
    }

        int mod = (int)1e9+7;// 取余，当被除数很大时，余数就是商0返回原值
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int n = nums1.length;
            int[] sorted = nums1.clone();
            Arrays.sort(sorted);
            long sum = 0, max = 0;
            for (int i = 0; i < n; i++) {
                int a = nums1[i], b = nums2[i];
                if (a == b) continue;//if条件满足时，continue后面的语句不再执行，直接进入下次循环
                int x = Math.abs(a - b);
                sum += x;
                int l = 0, r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (sorted[mid] <= b) l = mid;
                    else r = mid - 1;
                }
                int nd = Math.abs(sorted[r] - b);
                if (r + 1 < n) nd = Math.min(nd, Math.abs(sorted[r + 1] - b));
                if (nd < x) max = Math.max(max, x - nd);
            }
            return (int)((sum - max) % mod);
        }
    }
