class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount == 0) return 0;
        
        int min = Integer.MAX_VALUE;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        for(int coin: coins) {
            int target = amount - coin;
            if(target >= 0) {
                int result = minCoins(coins, target, memo);

                if(result != -1) min = Math.min(result + 1, min);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int minCoins(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        if(memo[amount] != -2) return memo[amount];

        int min = Integer.MAX_VALUE;

        for(int coin: coins) {
            int result = minCoins(coins, amount - coin, memo);

            if(result != -1) min = Math.min(result + 1, min);
        }
        memo[amount] = min == Integer.MAX_VALUE ? -1 : min;

        return memo[amount];
    }

}
