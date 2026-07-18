class Solution {
    public int maxArea(int[] heights) {
        int area = 0, left = 0, right = heights.length - 1;

        while(left < right) {
            int w = right - left;
            int h = Math.min(heights[left], heights[right]);

            area = Math.max(area, w*h);

            if(heights[right] < heights[left]) right--;
            else left++;
        }

        return area;
    }
}
