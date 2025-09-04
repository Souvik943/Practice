package practice.Sept042025.DSA;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 0 || nums.length == 1) return new int[]{-1, -1};
        HashMap<Integer, Integer> existing = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if(existing.containsKey(complement)) {
                return new int[]{existing.get(complement), i};
            }
            existing.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
