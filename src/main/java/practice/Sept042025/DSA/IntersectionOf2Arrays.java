package practice.Sept042025.DSA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class IntersectionOf2Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    set.add(k);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] res = new int[set.size()];
        for(int i=0; i<set.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
