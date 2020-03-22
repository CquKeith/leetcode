package Topic.DynamicProgrammingTopic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/3/22 13:45
 * 322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/
 **/
public class _322_CoinChange {


    public static void main(String[] args) {
        _322_CoinChange coinChange = new _322_CoinChange();
        //System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        //System.out.println(coinChange.coinChange(new int[]{2}, 3));
        System.out.println(coinChange.coinChange(new int[]{2,5, 10, 1}, 27));
    }

    /**
     * 自下向上 使用map替代数组
     * 但是耗时和空间逗比coinChangeArray要大
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> map = new HashMap<>(amount);
        map.put(0, 0);
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(min, map.getOrDefault(i - coin, amount + 1));
                }
            }
            map.put(i, 1 + min);
        }

        int ans = map.get(amount);
        return ans > amount ? -1 : ans;

    }

    /**
     * 自下而上
     * coins = [1,2,5],amount = 11
     * f(0) = 0
     * f(i) = min{f(i-coin[k])}+1
     * f(1) = min{f(0)+f(-1)+f()}
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeArray(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            dp[i] = 1 + min;
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * f(n) = 1+min{f(n-coins[i])}
     * 自上而下
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeUpToDown(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChangeUpToDown(coins, amount, new HashMap<>());

    }

    /**
     *
     * @param coins
     * @param amount
     * @param map memo 存储搜索过的，换当前amount所要用的最小的零钱
     * @return
     */
    private int coinChangeUpToDown(int[] coins, int amount, HashMap<Integer,Integer> map) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        int ans;
        if ((ans = map.getOrDefault(amount,0)) != 0) {
            return ans;
        }
        ans = Integer.MAX_VALUE;

        for (int coin : coins) {
            int min = Math.min(ans, coinChangeUpToDown(coins, amount - coin, map));
            if (min >= 0 && min < Integer.MAX_VALUE) {
                ans = Math.min(ans, 1 + min);
            }
        }

        ans = ans == Integer.MAX_VALUE ? -1 : ans;
        map.put(amount, ans);
        return ans;
    }
}
