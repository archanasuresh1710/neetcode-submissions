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
        
        if(nums.length < 3) return new ArrayList<>();
        
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++) {
            int start = i+1, end = nums.length-1;

            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0) {
                    set.add(List.of(nums[i], nums[start], nums[end]));
                    start++;
                }
                else if(sum < 0) start++;
                else end--;
            }
        } 

        return new ArrayList<>(set);
    }
}
