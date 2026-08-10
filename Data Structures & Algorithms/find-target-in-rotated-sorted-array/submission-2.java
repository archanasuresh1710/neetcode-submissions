class Solution {
    public int search(int[] nums, int target) {
        // O(n) approach: traverse through the array once to find the target

        /*
        approach 2: using binary search
        if mid = target - return
        else check which half is sorted num[mid] >= nums[left] left half sorted
            - check which if target belongs to sorted left section : if num[mid] > target and num[left] <= target -> search the left half
        num[right] >= num[mid] right half is sorted
            - check which if target belongs to sorted right section : if num[mid] < target and num[right] >= target -> search the right half
        */

        int left = 0, right = nums.length-1;

        while(left <= right) {
            
            int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;

            // find sorted half
            if(nums[left] <= nums[mid]) {
                // left half sorted
                if(nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // right half is sorted
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else right = mid - 1;
            }
        }

        return -1;
    }
}
