class Solution {
    public int climbStairs(int n) {
        // n = 1, no of ways: 1 -> 1
        // n = 2 no of ways: 1+1,2 -> 2
        // n = 3, no: 1+1+1,1+2,2+1 -> 3
        // n=4, no: 1+1+1+1,1+1+2,1+2+1,2+1+1,2+2 -> 5

        // at step i, no of ways = no of ways for step(i-1) + no of ways for step(i-2);

        if(n <=2) return n;

        int prev1 = 1, prev2 = 2, step = 0;

        for(int i=3;i<=n;i++) {
            step = prev1 + prev2;
            System.out.println("prev1: " + prev1 + " prev2: " + prev2 + " step: " + step);
            prev1 = prev2;
            prev2 = step;
        }

        return step;
    }
}
