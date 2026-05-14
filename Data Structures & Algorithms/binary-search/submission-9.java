class Solution {
    public int search(int[] nums, int target) {
        /*
        Input: nums = [-1,0,2,4,6,8], target = 4
        Output: 3
        */  
        // find middle of array. if mid > target, then its in the left side. if mid < target its in right side
        // if meid = target return index

        if(nums.length == 0) return -1;
        
        int left=0,right=nums.length-1;

        while(left <= right) {
           int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
