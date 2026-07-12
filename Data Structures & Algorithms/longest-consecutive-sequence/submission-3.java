class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        // nums = Arrays.stream(nums)
        //             .distinct()
        //             .toArray();

        // int start = 0;
        // int inc = 1;
        // int len = 0;
        // if(nums.length == 1) return 1;
        
        // for(int i=1;i<nums.length;i++) {
        //     if(nums[i] != nums[start] + inc) {
        //         start = i;
        //         inc = 1;
        //     } else {
        //         inc++;
        //     }
        //     len = Math.max(len, i - start + 1);
        // }

        // return len;

        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int len = 0;

        for(int num: set) {
            if(!set.contains(num - 1)) {
                int curr = num;
                int l = 1;

                while(set.contains(curr + 1)) {
                    curr++;
                    l++;
                }

                len = Math.max(len, l);
            }
        }
        return len;
    }
}
