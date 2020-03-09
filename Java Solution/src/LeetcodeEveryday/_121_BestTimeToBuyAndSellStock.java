package LeetcodeEveryday;

/**
 * @author chenmengliang
 * @date 2020/3/9 21:10
 * 121. 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 **/
public class _121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        _121_BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new _121_BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(new int[]{7,6,4,3,1}));
    }
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        // 记录历史最低价格
        int lastMinPrice = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            // 如果过去天数中最便宜的时候买入，第i天卖出，更新收益情况
            ans = Math.max(ans, prices[i] - lastMinPrice);
            // 更新历史最低价格
            lastMinPrice = Math.min(lastMinPrice, prices[i]);
        }

        return ans;
    }
}
