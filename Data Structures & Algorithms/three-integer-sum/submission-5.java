class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        brute force: for every ith number, fix a jth number and then find the number that adds up to 0 -> for every i, we run the loop nxn times -> O(n^3)
        approach 1: sort the array. for every ith number, find two numebrs in the (i+1, nums.length) range. thw two numbers a + b = -nums[i]
        two pointers: left = i+1, right is at the end 
        a+b = target, add combination to a set
        a+b < target -> move left front
        a+b > target -> move right back
        */
        
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++) {

            if(i!=0 && nums[i] == nums[i-1]) continue;

            int start = i+1, end = nums.length-1;

            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                    end--;

                    while(start < end && nums[start] == nums[start - 1]) start++;
                    while(start < end && nums[end] == nums[end + 1]) end--;
                }
                else if(sum < 0) start++;
                else end--;
            }
        } 

        return result;
    }
}
