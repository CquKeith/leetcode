package Topic.DynamicProgrammingTopic;

/**
 * @author chenmengliang
 * @date 2020/3/3 15:05
 * 64. 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 **/
public class _64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1},
        };
        _64_MinimumPathSum minimumPathSum = new _64_MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(grid));

    }

    /**
     * f(m-1,n-1) = min{f(m-2,n-1)+grid[m-2][n-1] , f(m-1,n-2)+grid[m-1][n-2]} + grid[m-1][n-1]
     * f(m,n) = min{f(m-1,n)+grid[m-1][n] , f(m,n-1)+grid[m][n-1]} + grid[m][n]
     * 左上角走到右下角最短，则每次只能向下或向右走
     * @param grid 网格
     * @return 从左上角走到右下角的最短路径和
     * 当然，由于grid[i][j]使用过之后就没用了，所以可以不借用额外的空间dp[][],也即是直接把dp[i][j]存储在grid[i][j]即可
     * 转移方程即改变成grid[i][j] += min(grid[i-1][j],grid[i][j-1])
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;

        // 1*1或者0*0的grid直接返回
        if (m == 0){
            return 0;
        }
        int n = grid[0].length;

        if (m == 1 && n == 1) {
            return grid[0][0];
        }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 一直横着走和一直竖着走的代价
        int i = 1, j = 1;
        while (i < m) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            ++i;
        }
        while (j < n) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            ++j;
        }

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {

                // 从左边和上边分别走到i，j的位置的路径和（不包括i，j节点）
                int fromLeft = dp[i - 1][j];
                int fromUp = dp[i][j - 1];
                dp[i][j] = Math.min(fromLeft, fromUp) + grid[i][j];

            }
        }

        return dp[m-1][n-1];
        
    }

}
