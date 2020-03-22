package CompanyInterviews2020.Kuaishou;

import java.util.Scanner;

/**
 * @author chenmengliang

 **/
public class Four {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        long[][] grid = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextLong();
            }
        }
        solution(grid, b, a);

    }

    /**
     *
     * @param grid
     * @param height 放置的电路板的高
     * @param width 方式的电路板的宽
     */
    private static void solution(long[][] grid, int height, int width) {

        if (grid.length <= width || width <= 0 || height <= 0) {
            return;
        }
        boolean[][] used = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid[0].length - width; i++) {
            for (int j = 0; j < grid.length - height; j++) {
                // 左上角是(i,j)
                // (i,j)~(i+width-1,j+height-1)的矩阵中的能量和
                long cost = calcCost(grid, i, i + width - 1, j, j + height - 1);

            }
        }

        System.out.println(0);
    }

    private static long calcCost(long[][] grid, int left, int right, int top, int bottom) {
        long sum = 0L;
        long minEnergy = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            for (int j = top; j <= bottom; j++) {
                sum += grid[i][j];
                minEnergy = Math.min(minEnergy, grid[i][j]);
            }
        }


        return sum - minEnergy * (right - left + 1) * (bottom - top + 1);
    }

}
