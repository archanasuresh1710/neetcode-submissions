class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        Input: nums = [-1,0,1,2,-1,-4]

        Output: [[-1,-1,2],[-1,0,1]]

        -----------
        nums = [-1,0,1,2,-1,-4]
        sorted = [-1,-1,0,1,2,4]
        */
        Arrays.sort(nums);

        // List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length;i++) {
            int target = nums[i];
            int start = i+1, end = nums.length-1;
            while(start < end) {
                
                int sum = nums[start] + nums[end] + target;
                if(sum == 0) {
                    set.add(List.of(target, nums[start], nums[end]));
                    start++;
                }
                else if(sum > 0) end--;
                else start++;
            }
        }
        
        return new ArrayList<>(set);
    }
}
