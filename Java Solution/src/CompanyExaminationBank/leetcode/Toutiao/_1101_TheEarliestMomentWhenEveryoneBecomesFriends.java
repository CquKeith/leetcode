package CompanyExaminationBank.leetcode.Toutiao;

import java.util.*;

/**
 * @author chenmengliang
 * @date 2020/3/14 22:18
 * 1101. 彼此熟识的最早时间
 * https://leetcode-cn.com/problems/the-earliest-moment-when-everyone-become-friends/
 * 在一个社交圈子当中，有 N 个人。每个人都有一个从 0 到 N-1 唯一的 id 编号。
 * <p>
 * 我们有一份日志列表 logs，其中每条记录都包含一个非负整数的时间戳，以及分属两个人的不同 id，logs[i] = [timestamp, id_A, id_B]。
 * <p>
 * 每条日志标识出两个人成为好友的时间，友谊是相互的：如果 A 和 B 是好友，那么 B 和 A 也是好友。
 * <p>
 * 如果 A 是 B 的好友，或者 A 是 B 的好友的好友，那么就可以认为 A 也与 B 熟识。
 * <p>
 * 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 * 输出：20190301
 * 解释：
 * 第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
 * 第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
 * 第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
 * 第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
 * 第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
 * 第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= N <= 100
 * 1 <= logs.length <= 10^4
 * 0 <= logs[i][0] <= 10^9
 * 0 <= logs[i][1], logs[i][2] <= N - 1
 * 保证 logs[i][0] 中的所有时间戳都不同
 * Logs 不一定按某一标准排序
 * logs[i][1] != logs[i][2]
 **/
public class _1101_TheEarliestMomentWhenEveryoneBecomesFriends {
    public static void main(String[] args) {
        _1101_TheEarliestMomentWhenEveryoneBecomesFriends theEarliestMomentWhenEveryoneBecomesFriends = new _1101_TheEarliestMomentWhenEveryoneBecomesFriends();

        //int[][] logs = {
        //        {20190101, 0, 1},
        //        {20190104, 3, 4},
        //        {20190107, 2, 3},
        //        {20190211, 1, 5},
        //        {20190224, 2, 4},
        //        {20190301, 0, 3},
        //        {20190312, 1, 2},
        //        {20190322, 4, 5}
        //};
        //int N = 6;
        //int[][] logs = {
        //        {3,0,3},
        //        {4,1,2},
        //        {0,2,0},
        //        {2,0,2},
        //        {8,0,3},
        //        {1,0,1},
        //        {5,1,2},
        //        {7,3,1},
        //        {6,1,0},
        //        {9,3,0}
        //};
        //int N = 4;
        int[][] logs = {
                {5, 4, 6},
                {0, 0, 3},
                {10, 5, 1},
                {2, 2, 1},
                {1, 4, 5},
                {4, 1, 3},
                {6, 5, 6},
                {11, 4, 2},
                {3, 1, 6},
                {7, 1, 0},
                {8, 1, 0},
                {9, 5, 6}
        };
        int N = 7;
        System.out.println(theEarliestMomentWhenEveryoneBecomesFriends.earliestAcqUnionFind(logs, N));
    }

    /**
     * 并查集方式
     * @param logs
     * @param N
     * @return
     */
    public int earliestAcqUnionFind(int[][] logs, int N) {
        if (logs.length <= 0 || N <= 0) {
            return -1;
        }

        // 先按照时间戳排序，以快速筛选出最早的时间：只要当前团队数降到1 就是最短的时间
        // 如果不排序，则不仅需要判断当前团队数==1，还必须要遍历完，每次更新最早时间
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);

        return unionFind(logs, N);
    }

    /**
     * 并查集：
     *  初始化每个人的圈子只有自己，也就是整个team的leader是自己
     *  遇到两个人，判断他们他们是不是在一个team，通过判断leader是否相同
     *  当最大team的size到N时，说明大家都在一个team了
     * @param logs
     * @param N
     * @return
     */
    public int unionFind(int[][] logs, int N) {

        Teams teams = new Teams(N);
        for (int[] log : logs) {
            teams.union(log[1], log[2]);
            if (teams.isOneTeam()) {
                return log[0];
            }
        }


        return -1;
    }

    /**
         * map<id,arrayList>装每个人所在的圈子
         * 遍历logs 判断两人所在的圈子
         * 如果只有一人在圈子，则把另外一人也加入该圈子
         * 如果两人都不在已有的圈子，则创建新的圈子
         * 如果两人都在圈子中，则看是否是两个不同的圈子，如果不同，则将两个圈子合并
         * 直到最大的圈子的人数==N
         * 如果遍历到最后最大的圈子还<N 就返回-1
         *
         * @param logs
         * @param N
         * @return
         */
    public int earliestAcq(int[][] logs, int N) {

        if (logs.length <= 0) {
            return -1;
        }

        // 按照时间戳排序
        //quickSort(logs, 0, logs.length - 1);

        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));

        System.out.println(Arrays.deepToString(logs));

        Map<Integer, List<Integer>> map = new HashMap<>(N);
        int maxCircle = 0;
        int earliestTimeStamp = Integer.MAX_VALUE;
        for (int[] log : logs) {
            int timestamp = log[0];
            int A = log[1];
            int B = log[2];
            List<Integer> currentList = new ArrayList<>();
            boolean containA = map.containsKey(A);
            boolean containB = map.containsKey(B);
            // A B都不在已知圈子，则创造新的圈子
            if (!containA && !containB) {
                currentList.add(A);
                currentList.add(B);
                map.put(A, currentList);
                map.put(B, currentList);
            } else {
                // A B 都在圈子 则若圈子不同，则合并圈子
                if (containA && containB) {
                    List<Integer> circleA = map.get(A);
                    List<Integer> circleB = map.get(B);
                    if (circleA != circleB) {
                        currentList = mergeList(circleA, circleB);
                        // 此处不能更改A和B对应的List，要更新currentList  中所有的数字，映射到currentList
                        List<Integer> finalCurrentList = currentList;
                        currentList.forEach(item-> map.put(item, finalCurrentList));

                    }
                } else if (containA) {
                    // A在已知圈子，B不在
                    currentList = map.get(A);
                    currentList.add(B);
                    map.put(B, currentList);
                } else {
                    currentList = map.get(B);
                    currentList.add(A);
                    map.put(A, currentList);
                }
            }
            maxCircle = Math.max(maxCircle, currentList.size());

            // 由于已经按照时间排序，因为首次最大圈子是N时，就是最早的符合条件的时间
            if (maxCircle == N) {
                earliestTimeStamp = Math.min(earliestTimeStamp, timestamp);
                break;
            }
        }
        return maxCircle == N ? earliestTimeStamp : -1;
    }

    public void quickSort(int[][] logs, int low, int high) {
        if (low < high) {
            int pivotPos = partition(logs, low, high);
            quickSort(logs, low, pivotPos - 1);
            quickSort(logs, pivotPos + 1, high);
        }
    }

    public int partition(int[][] logs, int low, int high) {

        int[] pivot = Arrays.copyOf(logs[low], logs[low].length);

        while (low < high) {

            while (low < high && logs[high][0] > pivot[0]) {
                --high;
            }

            System.arraycopy(logs[high], 0, logs[low], 0, 3);

            while (low < high && logs[low][0] < pivot[0]) {
                ++low;
            }
            System.arraycopy(logs[low], 0, logs[high], 0, 3);
        }
        System.arraycopy(pivot, 0, logs[low], 0, 3);

        return low;

    }

    public List<Integer> mergeList(List<Integer> circleA, List<Integer> circleB) {
        Set<Integer> set = new HashSet<>(circleA);
        set.addAll(circleB);

        return new ArrayList<>(set);
    }
}
 class Teams {
    // 总人数人数
    //private int peopleNum;

    // 当前的团队数
    private int teamNum;

    // 每个团队的leader
    private int[] leader;

    public Teams(int peopleNum) {
        //this.peopleNum = peopleNum;

        // 初始化每个team的leader的都是自己
        leader = new int[peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            leader[i] = i;
        }
        // 每个人都是一个team
        this.teamNum = peopleNum;
    }

    /**
     * 将A和B分别所在的团队 融合
     * @param A
     * @param B
     */
    public void union(int A, int B) {
        int leaderOfA = findLeader(A);
        int leaderOfB = findLeader(B);
        if (leaderOfA != leaderOfB) {
            // 合并两个team
            teamNum--;
            // leaderB作为leaderOfA的leader 、 leaderA做leaderOfB的leader都行，因为同一个team的，都是"串"在一起的
            leader[leaderOfA] = leaderOfB;
        }
    }

    public boolean isOneTeam() {
        return teamNum == 1;
    }

    private int findLeader(int a) {
        // 持续让上找，直到找到a的leader是自己，也就是找到team的leader
        return leader[a] == a ? a : findLeader(leader[a]);
    }

}