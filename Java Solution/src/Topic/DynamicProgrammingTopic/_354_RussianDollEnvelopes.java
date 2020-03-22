package Topic.DynamicProgrammingTopic;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2020/3/21 19:03
 * 354. 俄罗斯套娃信封问题
 * https://leetcode-cn.com/problems/russian-doll-envelopes/
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 * 说明:
 * 不允许旋转信封。
 *
 * 示例:
 *
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 **/
public class _354_RussianDollEnvelopes {
    public static void main(String[] args) {
        _354_RussianDollEnvelopes russianDollEnvelopes = new _354_RussianDollEnvelopes();
        int[][] envelopes = {
                {5, 4}, {6, 4}, {6, 7}, {2, 3}
        };
        int[][] envelopes2 = {
                {46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}
        };
        int[][] envelopes3 = {
                {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {5, 5}, {6, 7}, {7, 8}
        };
        System.out.println(russianDollEnvelopes.maxEnvelopes(envelopes3));

    }


    /**
     * 排序时，按照x的升序，x相等的按照y的降序排序
     * 这样的好处是：排序之后只需要对y求最大上升子序列的长度即可，因为x相等的，前面的y要大，自然会跳过
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes.length <= 1) {
            return envelopes.length;
        }

        // 排序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        // 下面求y一列的最大上升子序列即可
        // 类似leetcode 300
        int[] dimY = Arrays.stream(envelopes).mapToInt(envelope -> envelope[1]).toArray();
        return longestIncreasingSubsequence(dimY);

    }

    /**
     * 求 envelopes 的第二列Y，的最大上升子序列的长度
     * Y的特征：阶段性递减，也就是分成了很多段，每段之间大小没关系，但是段内是递减的（每一段，其实对应着X值是相等的）
     * @param nums
     * @return
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int[] tail = new int[nums.length];
        int ans = 1;
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > tail[ans - 1]) {
                tail[ans++] = num;
            } else {
                // 搜索tail[0,ans)中，比num大的最小数，如果没有，则将tail[ans]=num,ans++
                int left = 0, right = ans;
                while (left < right) {
                    int mid = (left + right) >> 1;
                    if (tail[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = num;
            }
        }

        return ans;
    }

    /**
     * O(n2)
     * @param envelopes
     * @return
     */
    private int longestIncreasingSubsequenceOn2(int[][] envelopes) {
        int ans = 0;

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int end = 1; end < envelopes.length; end++) {

            int current = envelopes[end][1];

            for (int i = 0; i < end; i++) {
                if (envelopes[i][1] < current) {
                    dp[end] = Math.max(dp[end], dp[i]);
                }
            }
            dp[end] += 1;
            ans = Math.max(ans, dp[end]);
        }

        return ans;
    }

    /**
     * (x,y)按照x优先，y次优先对envelopes排序
     * 然后求的最长上升序列：
     *  要求x,y都要比前面的大，才是上升
     *  if f[i][0]>f[i-1][0] && f[i][1]>f[i-1][1] then
     *      dp[i] = dp[i-1]+1
     *  else then
     *      dp = dp[j]+1 if j>=0 else 1, j is the index of the maximum value that less than f[i][]
     *
     * O(n2)
     * @param envelopes
     * @return
     */
    public int maxEnvelopesOn2(int[][] envelopes) {

        if (envelopes.length <= 1) {
            return envelopes.length;
        }

        // 先排序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 最大上升子序列
        int max = 1;
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int end = 1; end < envelopes.length; end++) {
            int[] endEnv = envelopes[end];
            // [j,i]中dp的最大值
            for (int i = 0; i < end; i++) {
                if (endEnv[0] > envelopes[i][0] && endEnv[1] > envelopes[i][1]) {
                    // 现求出在end之前的dp的最大值
                    dp[end] = Math.max(dp[end], dp[i]);
                }
            }

            // 加上end自己
            dp[end] += 1;
            max = Math.max(dp[end], max);
        }
        return max;
    }


}
