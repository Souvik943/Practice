package practice.Sept042025.DSA;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sumToBeRemembered = 0;
        for(int i=0; i<nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target - sum) < minDiff) {
                    minDiff = Math.abs(target - sum);
                    sumToBeRemembered = sum;
                }
                if(sum == target) return target;
                if(sum > target) right--;
                else left++;
            }
        }
        return sumToBeRemembered;
    }
}
