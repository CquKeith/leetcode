package CompanyInterviews2020.WanmeiWorld;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author chenmengliang
 * 最小生成树,并查集
 * 60%
 * 数组越界？
 **/
public class MinimumCreateTree {
    public static void main(String[] args) {
        MinimumCreateTree minimumCreateTree = new MinimumCreateTree();
        Scanner scanner = new Scanner(System.in);
        // 节点数量
        int num = scanner.nextInt();
        UnionFind unionFind = new UnionFind(num);

        // 存储每条边的权重
        int[][] ver = new int[num][3];
        for (int i = 0; i < num; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int weight = scanner.nextInt();
            // 是否已经右边
            int hasConstruct = scanner.nextInt();
            if (hasConstruct == 1) {
                unionFind.union(x,y);
            } else {
                // 只关心没连通的
                ver[i] = new int[]{x, y, weight};
            }
        }
        // 按照权重排序，优先选择权重小的边
        Arrays.sort(ver, Comparator.comparingInt(a -> a[2]));

        System.out.println(minimumCreateTree.kruskal(ver, unionFind));

    }

    /**
     * 克鲁斯卡尔
     * @return
     */
    public int kruskal(int[][] grid, UnionFind unionFind) {
        if (grid.length == 0) {
            return 0;
        }

        int ans = 0;

        for (int[] node : grid) {
            if (unionFind.setNum <= 1) {
                return ans;
            }
            if (unionFind.union(node[0], node[1]) == 1) {
                ans += node[2];
            }
        }

        return ans;

    }
}
class UnionFind{
    // 节点个数
    int nodeNum;

    // 集合的数量
    int setNum;

    // 每个集合的头
    int[] leader;

    public UnionFind(int N) {
        nodeNum = N;
        setNum = N;
        leader = new int[N+1];
        for (int i = 1; i <= N; i++) {
            leader[i] = i;
        }
    }

    /**
     * 两个节点之间union
     * @param x
     * @param y
     * @return 连接成功返回1，否则返回0
     */
    public int union(int x, int y) {

        if (setNum <= 1 || x > nodeNum || y > nodeNum) {
            return 0;
        }

        int leaderX = find(x);
        int leaderY = find(y);
        if (leaderX != leaderY) {
            leader[x] = y;
            setNum--;
            return 1;
        } else {
            return 0;
        }
    }

    private int find(int x) {

        return x == leader[x] ? x : find(leader[x]);
    }
}
