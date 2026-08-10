class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*
        approach 1: iterating over the entire array to find the targets and keeping track of the indexes that they appear
            - if list is empty, store the index
            - if list is not empty, overwrite last element until we finish iterating
        time: O(n) 
        space: O(1) for storing only two indexes

        approach 2: use binary search to find the target
            - when nums[mid] = target -> consider that as the rightmost occurence [note the index]
                    - keep searching the left side until left crosses
                    - the noted index would be the leftmost index
            - when nums[mid] = target -> consider that as the leftmost occurnce 
                    - keep searching the right side 
                    - noted index would be last index
            two binary searches to be done
        time: O(log n)
        */

        int first = leftBinarySearch(nums,target);
        int last = rightBinarySearch(nums,target);

        return new int[]{first,last};
    }

    private int leftBinarySearch(int nums[], int target) {

        int left = 0, right = nums.length-1, index = nums.length;

        while(left <= right) {
            int mid = (right + left)/2;

            if(nums[mid] == target) {
                index = Math.min(mid, index);
                right = mid - 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            } else left = mid + 1;
        }

        return index == nums.length ? -1 : index;
    }

      private int rightBinarySearch(int nums[], int target) {

        int left = 0, right = nums.length-1, index = -1;

        while(left <= right) {
            int mid = (right + left)/2;

            if(nums[mid] == target) {
                index = Math.max(mid, index);
                left = mid + 1;
            }
            else if(nums[mid] > target) {
                right = mid - 1;
            } else left = mid + 1;
        }

        return index;
    }
}