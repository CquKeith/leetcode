package CompanyExaminationBank.leetcode.Toutiao;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenmengliang
 * @date 2020/3/15 22:08
 * 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * 输出: 3
 **/
public class _200_NumberOfIslands {
    public static void main(String[] args) {
        _200_NumberOfIslands numberOfIslands = new _200_NumberOfIslands();
        // 1个
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        // 3个
        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        // 1个
        char[][] grid3 = {
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'}
        };
        System.out.println(numberOfIslands.numIslands(grid1));
        System.out.println(numberOfIslands.numIslands(grid2));
        System.out.println(numberOfIslands.numIslands(grid3));

    }

    /**
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (null == grid || grid.length <= 0) {
            return 0;
        }

        return UnionFindSolution(grid);
    }

    /**
     * 并查集的解法：
     * 所有相连的'1'是一个Team，最终确定有几个team即可
     *
     * @param grid
     * @return
     */
    private int UnionFindSolution(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);

        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    // 上边
                    if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                        unionFind.union((i * n + j), (i - 1) * n + j);
                    }
                    // 下边
                    if (i < m - 1 && grid[i + 1][j] == '1') {
                        unionFind.union((i * n + j), (i + 1) * n + j);
                    }
                    // 左边
                    if (j > 0 && grid[i][j - 1] == '1') {
                        unionFind.union((i * n + j), i * n + j - 1);
                    }
                    // 右边
                    if (j < n - 1 && grid[i][j + 1] == '1') {
                        unionFind.union((i * n + j), i * n + j + 1);

                    }
                }
            }
        }

        return unionFind.getCount();
    }

    /**
     * 广度优先遍历（非递归）
     * 借助队列
     * 每次一个节点入队时，将上下左右的符合条件的节点入队
     * 每次遍历，访问当前队列中的所有节点
     *
     * @param grid
     * @return
     */
    private int BFSSolutionNotRecursive(char[][] grid) {
        int num = 0;

        Deque<int[]> deque = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    deque.add(new int[]{i, j});
                    grid[i][j] = '0';

                    // 遍历当前节点之间或间接连接的所有'1'
                    while (!deque.isEmpty()) {
                        int row = deque.peek()[0];
                        int column = deque.peek()[1];
                        deque.remove();

                        // 添加(i,j)周围的'1'的节点
                        // 上边
                        if (row > 0 && grid[row - 1][column] == '1') {
                            deque.addLast(new int[]{row - 1, column});
                            grid[row - 1][column] = '0';
                        }
                        // 下边
                        if (row < m - 1 && grid[row + 1][column] == '1') {
                            deque.addLast(new int[]{row + 1, column});
                            grid[row + 1][column] = '0';
                        }
                        // 左边
                        if (column > 0 && grid[row][column - 1] == '1') {
                            deque.addLast(new int[]{row, column - 1});
                            grid[row][column - 1] = '0';
                        }
                        // 右边
                        if (column < n - 1 && grid[row][column + 1] == '1') {
                            deque.addLast(new int[]{row, column + 1});
                            grid[row][column + 1] = '0';
                        }
                    }


                }
            }
        }

        return num;
    }


    /**
     * 深度优先遍历(递归)：
     * 从一个'1'开始深度优先遍历，每遍历完一次，小岛数量+1
     * 遍历后的节点，赋值为'2'
     *
     * @param grid
     * @return
     */
    private int DFSSolutionRecursive(char[][] grid) {

        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            char[] line = grid[i];
            for (int j = 0; j < line.length; j++) {
                if (line[j] == '1') {
                    num++;
                    // dfs将与当前节点在同一岛屿的节点，标记为'-1'
                    dfs(grid, i, j);
                }
            }
        }

        return num;

    }

    /**
     * @param grid
     * @param row
     * @param column
     */
    private void dfs(char[][] grid, int row, int column) {

        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] != '1') {
            return;
        }
        grid[row][column] = '2';

        // 右边
        dfs(grid, row, column + 1);
        // 下边
        dfs(grid, row + 1, column);
        // 左边
        dfs(grid, row - 1, column);
        // 上边
        dfs(grid, row, column - 1);

    }
}

class UnionFind {
    // 存放每个节点的父节点
    // 每个节点的编号，按照行优先从0开始编号
    int[] parent;

    // Rank[i]表示以 i 为根节点的集合的层数，即树的高度
    // 加上rank[] 可以不要让树太高，减少find的次数
    // https://blog.csdn.net/qq_19782019/article/details/78916595?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
    int[] rank;


    // 岛屿的数量
    int count=0;

    public UnionFind(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int currentIndex = i * n + j;
                if (grid[i][j] == '1') {
                    parent[currentIndex] = currentIndex;
                    // 初始化，每个'1'都是独立的岛屿
                    ++count;
                }
                rank[currentIndex] = 0;

            }
        }
    }

    /**
     * @param x 从（0，0）对应0开始，行优先的编号
     * @param y
     */
    public void union(int x, int y) {
        // 找到当前节点的root
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            // 层数小的，挂在层数大的上面
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                // 如果两层都相等，则选择一个A挂在另一个B下面
                // B因此会多了一层

                parent[rootX] = rootY;
                rank[rootY] += 1;
            }
            // union一次 岛屿减少一个，因为合并了
            --count;
        }


    }

    public int getCount() {
        return count;
    }

    private int find(int i) {
        //
        return i == parent[i] ? i : find(parent[i]);
    }
}

