import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/10/14 10:34
 * 动态规划迷宫
 **/
public class MazeDPSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] maze = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = scanner.nextInt();

            }
        }
        System.out.println(Arrays.deepToString(maze));

        System.out.println(calcNumOfPossiblePath(maze));

    }

    /**
     * dp[i][j] 表示从[0,0]到[i,j]的路径数
     * dp[0][j] = 1 where maze[0][j] = 0
     * dp[i][0] = 1 where maze[i][0] = 0
     * dp[i][j] = dp[i-1][j] + dp[i][j-1] where maze[i][j] = 0 (因为只能往下或者往右走)
     * dp[i][j] = 0 where maze[i][j] = 1
     * @param maze 迷宫矩阵
     * @return 可能的路径数
     */
    private static int calcNumOfPossiblePath(int[][] maze){
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = maze[i][0] == 0? 1 : 0;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = maze[0][j] == 0? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = maze[i][j] == 0?dp[i-1][j] + dp[i][j-1]:0;
            }
        }

        return dp[m-1][n-1];

    }
}
