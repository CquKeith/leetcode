package Topic.DynamicProgrammingTopic;

/**
 * @author chenmengliang
 * @date 2020/3/3 16:47
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 **/
public class _63_UniquePathsII {
    public static void main(String[] args) {
        _63_UniquePathsII uniquePathsII = new _63_UniquePathsII();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] obstacleGrid2 = {
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obstacleGrid2));
    }

    /**
     * 与62题一样，只是在有障碍的地方，路径肯定等于0 即可
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 有障碍的地方，肯定不可达，到此的路径数则一定为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else { // （i，j）处没有障碍
                    // 第一行或第一列
                    if (i == 0 || j == 0) {
                        // 此处不是一定是1，因为当前（i，j）的前面一步有障碍时，则不能从前面一步向右或者向下走
                        // 当前(i,j)没有障碍，则（i，j）处的path数和上一步一致
                        if (i > 0) {
                            dp[i][j] = dp[i - 1][j];
                        } else if (j > 0) {
                            dp[i][j] = dp[i][j - 1];
                        }
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];

    }

}
