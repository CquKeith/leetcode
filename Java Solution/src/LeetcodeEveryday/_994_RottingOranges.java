package LeetcodeEveryday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenmengliang
 * @date 2020/3/4 13:21
 * 994. 腐烂的橘子
 * https://leetcode-cn.com/problems/rotting-oranges/
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 示例 3：
 * <p>
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 **/
public class _994_RottingOranges {
    public static void main(String[] args) {
        _994_RottingOranges rottingOranges = new _994_RottingOranges();
        int[][] grid1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        int[][] grid2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        int[][] grid3 = {
                {0, 2}
        };
        int[][] grid4 = {
                {1}
        };
        int[][] grid5 = {
                {1, 2}
        };
        System.out.println(rottingOranges.orangesRotting(grid1));

    }

    /**
     * BFS ， 或者层次遍历
     * 首先将所有污染的橘子入队
     * 从每个腐烂的橘子出发，层次遍历
     * 遍历完成时，如果还有未被污染的橘子，则返回-1，否则返回遍历的层数（每次遍历一层，每次1min）
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;

        int depth = 0;

        Queue<Point> queue = new LinkedList<>();
        loadAllRotedOranges(grid, queue);

        while (!queue.isEmpty()) {

            // 将所有的节点挨个出队，并污染四周的橘子节点
            int count = rotOranges(queue, grid, m, n);
            // 如果已经停止污染，则后面更不会污染
            // 主要防止，最后一个被污染的橘子，在下一轮本要去污染其他橘子，但是经过rotOranges之后，并未污染任何橘子，那么depth 就不应该+1
            if (count == 0) {
                break;
            }

            // "污染"一圈，深度+1
            depth++;

        }
        int leftFreshOrangesNum = countFreshOrangesNum(grid);
        return leftFreshOrangesNum > 0 ? -1 : depth;

    }

    /**
     * 将所有的节点挨个出队，并污染四周的橘子节点
     * @param queue
     * @param grid
     * @param m
     * @param n
     * @return 本次污染的个数
     */
    private int rotOranges(Queue<Point> queue, int[][] grid, int m, int n) {

        int size = queue.size();
        // 本次污染的个数
        int count = 0;

        // 现有队列中的所有节点 ，均"污染"一次周围的节点
        while (size -- > 0) {
            Point point = queue.poll();
            // 找到point的四周的新鲜橘子节点（值为1），并"污染"它们，并将其入队
            int x = point.x;
            int y = point.y;
            // up
            if (x > 0 && grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                count++;
                queue.add(new Point(x - 1, y));
            }
            // down
            if (x < m - 1 && grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                count++;
                queue.add(new Point(x + 1, y));
            }
            // left
            if (y > 0 && grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                count++;
                queue.add(new Point(x, y - 1));
            }
            // right
            if (y < n - 1 && grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                count++;
                queue.add(new Point(x, y + 1));
            }

        }
        return count;
    }

    /**
     * 加载所有的腐烂橘子
     *
     * @param grid
     * @param queue
     */
    private void loadAllRotedOranges(int[][] grid, Queue<Point> queue) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
    }


    /**
     * 计算未被污染的橘子个数
     *
     * @param grid
     * @return
     */
    private int countFreshOrangesNum(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ++count;
                }
            }
        }
        return count;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

}
