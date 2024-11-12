package test;

import java.util.*;

public class Timu {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 9};
        int[] b = {3, 4, 5, 9, 10, 11, 12};
        System.out.println(Arrays.toString(find(a, b)));

    }


    public static int[] find(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                list.add(arr1[i]);
                i++;
                j++;
            }
        }
        int[] ints = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            ints[k] = list.get(k);
        }
        return ints;
    }
}
