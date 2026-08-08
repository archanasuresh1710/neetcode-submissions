class Solution {
    public int change(int amount, int[] coins) {
        // number of combinations that add up to amount
        // no combinations - 0

        // coin - 1 => target = amount - 1 
        // result_1 => 1 + all possible combinations to get target
        // result_5 => target = amount -5 => 1 + all possible combinations to get target

        // amt 4 coins = 1,2,3
        // c1 -> 1,1,1,1 | 1,1,2 | 1,3 | 2,2

        if(amount == 0) return 1;

        int c = 0;
        int[][] memo = new int[coins.length][amount+1];
        for(int[] row: memo) {
            Arrays.fill(row, -1);
        }

        return combinations(coins, amount, memo, 0);
    }

    private int combinations(int[] coins, int amount, int[][] memo, int index) {
        if(amount == 0) return 1;
        if(amount < 0) return 0;

        if(memo[index][amount] != -1) {
            return memo[index][amount];
        };

        int c = 0;

        for(int i=index;i<coins.length;i++) {
            int comb = combinations(coins, amount - coins[i], memo, i);
            if(comb != -1) {
                c += comb;
            }
        }

        memo[index][amount] = c;

        return c;
    }
}
