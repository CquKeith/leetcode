package CompanyExaminationBank.leetcode.Huawei;

/**
 * @author chenmengliang
 * @date 2020/3/13 15:08
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 **/
public class _221_MaximalSquare {
    public static void main(String[] args) {
        _221_MaximalSquare maximalSquare = new _221_MaximalSquare();
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        char[][] empty = {{}};

        //System.out.println(maximalSquare.maximalSquare(matrix));
        System.out.println(maximalSquare.maximalSquare(empty));

    }

    /**
     * dp[i][j]表示以(i,j)为右下角的只包含 1 的最大正方形的边长
     * A 表述矩阵
     * dp[i][0] = A[i][0]
     * dp[0][j] = A[0][j]
     * i>1 && j>1时
     *  dp[i][j] = 0 if A[i][j] == 0
     *            min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1 else
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        // 保存最大正方形的边长
        int maxSquareLength = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        // min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
                        int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                        min = Math.min(dp[i - 1][j - 1], min);
                        dp[i][j] = min + 1;
                    }
                }
                maxSquareLength = Math.max(maxSquareLength, dp[i][j]);
            }
        }
        return maxSquareLength * maxSquareLength;
    }

}
