class Solution {
    public int singleProfit(int[] prices, int start, int end) {
        if(prices == null || prices.length == 0) return 0;
        int profit = 0;
        for(int i = start; i <= end - 1; i ++){
            for(int j = i+1; j <= end; j ++){
                if(prices[j] - prices[i] > profit) profit = prices[j] - prices[i];
            }
        }
        return profit;
    }

    public int maxProfit(int[] prices) {
        // if(prices == null || prices.length == 0) return 0;
        // int profit = 0;
        // for(int i = 0; i < prices.length; i ++){
        //     // if(i >= 1 && prices[i] < prices[i-1]) continue;
        //     // else if(i+1 < prices.length && prices[i] > prices[i+1] ) continue;
        //     if(singleProfit(prices, 0, i) + singleProfit(prices, i, prices.length - 1) > profit){
        //         profit = singleProfit(prices, 0, i) + singleProfit(prices, i, prices.length - 1);
        //     }
        // }
        // return profit;
        if(prices == null || prices.length == 0) return 0;
        int firstbuy = Integer.MAX_VALUE;
        int firstsell = Integer.MIN_VALUE;
        int secondbuy = Integer.MAX_VALUE;
        int secondsell = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length; i ++){
            firstbuy = Math.min(firstbuy, prices[i]);
            firstsell = Math.max(firstsell, prices[i] - firstbuy);
            secondbuy = Math.min(secondbuy, prices[i] - firstsell);
            secondsell = Math.max(secondsell, prices[i] - secondbuy);
        }
        return secondsell;
    }
}