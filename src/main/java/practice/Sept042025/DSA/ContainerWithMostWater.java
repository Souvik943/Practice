package practice.Sept042025.DSA;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1) return 0;
        int left = 0;
        int right = height.length - 1;
        int maxCapacity = 0;
        while(left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            int capacity = minHeight * width;
            maxCapacity = Math.max(maxCapacity, capacity);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxCapacity;
    }
}
