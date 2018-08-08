class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = prices[0];
        int profit = max - min;
        for(int i = 0; i < prices.length; i ++){
            for(int j = i+1; j < prices.length; j ++){
                if(prices[j] - prices[i] > profit) profit = prices[j] - prices[i];
            }
        }
        return profit;
    }
}