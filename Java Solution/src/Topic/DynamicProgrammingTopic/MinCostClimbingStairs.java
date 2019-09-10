package Topic.DynamicProgrammingTopic;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/8 22:33
 * [746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)
 **/
public class MinCostClimbingStairs {
    public static void main(String[] args) {

        int[][] tests = {{10, 15, 20}, {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}};
        for (int[] test :
                tests) {
            System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(test));
        }


    }

    /**
     * 动态规划解法：
     * f(0) = A0
     * f(1) = min(A0,A1)
     * f(2) = min(f(0),f(1))+A2
     * ...
     * f(n) = min(f(n-1),f(n-2)) + An     if     n不是最后一个数字
     * min(f(n-1),f(n-2)+An)       else   n是最后一个数字
     *
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (null == cost || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = Math.min(dp[0] + cost[1], cost[1]);
        for (int i = 2; i < length - 1; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后一个
        dp[length - 1] = Math.min(dp[length - 1 - 1], dp[length - 1 - 2] + cost[length - 1]);

        System.out.println(Arrays.toString(dp));

        return dp[length - 1];
    }
}
