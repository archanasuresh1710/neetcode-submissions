class Solution {
    public int maxProfit(int[] prices) {
        // 10 1 5 6 7 1 buy at 1 and sell at 7 -> profit = 6
        // 10 1 5 4 7 1 buy at 1 and sett at 7 -> profit = 6

        // we need to find the buying point 
        // if a[i] > a[i+1] then a[i+1] becomes buying point
        // calculate max profit at each step

        int profit=0;
        int bp = prices[0];

        // 10 4 5 1 7 1 buy at 1 and sett at 7 -> profit = 6
        // i=1 bp=4 p=1
        // i=2 bp=1 p=1
        // i=4 bp=1 p=6 
        for(int i=1;i<prices.length;i++) {
            if(bp - prices[i] > 0) {
                bp = Math.min(bp, prices[i]);
            } else if(bp - prices[i] < 0) {
                profit = Math.max(profit, prices[i]-bp);
            }
        }

        return profit;
    }
}
