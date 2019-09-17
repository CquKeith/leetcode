package CompanyInterviews2020.LeetcodeMockExams;

/**
 * @author chenmengliang
 * @date 2019/9/4 22:28
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 **/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int [][]testPrices = {
                                 {7,1,5,3,6,4},
                                 {7,6,4,3,1}
                             };
        for (int[] prices :
                testPrices) {
            System.out.println(new BestTimeToBuyAndSellStock().maxProfitOneTraversal(prices));
        }
    }

    /**
     * 暴力解决
     * @param prices
     * @return
     */
    private int maxProfitForce(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                maxProfit = Math.max(prices[j] - prices[i],maxProfit);
            }
        }
        return maxProfit < 0?0:maxProfit;
    }

    /**
     * 经过一次遍历
     *  每走一步 更新最小值，和 最大收益
     * @param prices
     * @return
     */
    private int maxProfitOneTraversal(int[] prices){
        if (null == prices || prices.length <= 1){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price :
                prices) {
            minPrice = Math.min(minPrice,price);
            maxProfit = Math.max(maxProfit,price - minPrice);
        }
        return maxProfit;
    }

}
