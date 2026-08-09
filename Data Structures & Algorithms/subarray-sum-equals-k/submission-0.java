class Solution {
    public int subarraySum(int[] nums, int k) {
        // brute force: for each ith element, add the next elements until we reach the end of array or the sum -> O(nxn)
        // sliding window approach: fix left and right pointers and move right across the array. shift left when the sum is not equal to k. BUT this would fail when we encounter negative numbers
        // prefix sum of [2, -1, 1, 2] -> [2, 1, 2, 4]
        // at any i, check whether there exists a prefix[j] = prefix[i] - k

        // [4,4,4,4,4,4], k = 4
        // prefix = [4, 8, 12, 16, 20, 24]
        // at p[0] - k = 0 -> count = 1 (empty prefix)
        // p[1] - k = 4, there exist 1 prefix -> count = 2
        // p[2] -k = 8, count = 3
        // ... p[5] - k = 20, count = 6

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // empty prefix;

        int prefixSum = 0, result = 0;

        for(int i=0;i<nums.length;i++) {
            prefixSum += nums[i];
            int target = prefixSum - k;

            if(map.containsKey(target)) result += map.get(target);

            map.put(prefixSum, map.getOrDefault(prefixSum, 0)+1);
        }

        return result;

    }
}