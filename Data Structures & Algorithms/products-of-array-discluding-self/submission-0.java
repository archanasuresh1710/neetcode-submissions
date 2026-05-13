class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] pr = new int[nums.length];
        int[] pl = new int[nums.length];
        int lpro = 1, rpro = 1;
        pl[0] = lpro;
        pr[nums.length-1] = rpro;

        for(int i=1;i<nums.length;i++) {
            lpro *= nums[i-1];
            pl[i] = lpro; 

            rpro *= nums[nums.length - i];
            pr[nums.length - 1 -i] = rpro;
        }

        // System.out.println(Arrays.toString(pl));
        // System.out.println(Arrays.toString(pr));

        for(int i=0;i<pl.length;i++) {
            result[i] = pl[i] * pr[i];
        }

        return result;
    }
}  


/**
Input: nums = [1,2,4,6]
Output: [48,24,12,8]

[1,2,4,6]

product to right = [48, 24, 6, 1]
product to left = [1, 1, 2, 8]
*/