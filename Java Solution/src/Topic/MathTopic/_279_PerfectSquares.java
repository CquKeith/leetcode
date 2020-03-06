package Topic.MathTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/3/6 11:49
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 **/
public class _279_PerfectSquares {

    public Map<Integer, Integer> memo = new HashMap<>() {{
        put(1, 1);
        put(2, 2);
        put(3, 3);
        put(4, 1);
        put(5, 2);
    }};

    public static void main(String[] args) {
        _279_PerfectSquares perfectSquares = new _279_PerfectSquares();
        System.out.println(perfectSquares.numSquares(12));
        System.out.println(perfectSquares.numSquares(13));
        System.out.println(perfectSquares.numSquares(7168));

    }

    /**
     * 动态规划解法
     * dp[n+1],存储1～n对应的最小的ans
     * dp[n]最大是n，也即是拆成全1相加
     * dp[i] = min(dp[i],dp[n-j*j]+1)
     * 从1开始遍历，更新dp数组
     * 思想跟下面的方法差不多，只是不用递归了
     * @param n 正整数
     * @return n拆成平方数的和 这些平方数的最少个数
     */
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 初始化为最大值
            dp[i] = i;
            int temp;

            // 搜索dp[i],搜索范围[1,i]
            for (int j = 1; (temp = i-j*j) >= 0; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[temp]);
            }

        }
        return dp[n];
    }


    /**
     * 这种方法使用递归+memo，比较耗时
     * 12：拆成9，则f(12) = 1+f(12-9),拆成4，则f(12)=1+f(12-4),拆成1，则f（12）=1+f(11)
     * 所以f(12)=1+min(f(11),f(8),f(3))
     * 所以每次找n以内的所有平方数然后进行拆分,取最小值
     *
     * @param n 正整数
     * @return n拆成平方数的和 这些平方数的最少个数
     */

    public int numSquaresCostMuchTime(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        int ans = Integer.MAX_VALUE;
        // 开方向下取整
        int sqrt = (int) Math.floor(Math.sqrt(n));
        // 找出平方小于n的所有数
        for (int i = sqrt; i > 0; i--) {
            int i2 = i * i;
            // 刚好当前的数就是个完全平方数
            if (i2 == n) {
                memo.put(n, 1);
                return 1;
            }
            // i*i肯定小于n
            // f(n)=1+f(n-i*i)
            int left = n - i2;
            int currentMinLen;
            if (memo.containsKey(left)) {
                currentMinLen = 1 + memo.get(left);
            } else {
                currentMinLen  = 1 + numSquaresCostMuchTime(n-i2);
            }

            // 求的f（n）的这种组合之后，更新最短的组合
            ans = Math.min(ans, currentMinLen);
            // ans 更新之后才存入memo，因为memo中存的都是n对应的最短的平方个数
            memo.put(n, ans);

        }

        return ans;
    }
}
