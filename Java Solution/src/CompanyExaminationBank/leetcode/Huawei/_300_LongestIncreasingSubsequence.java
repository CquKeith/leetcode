package CompanyExaminationBank.leetcode.Huawei;

/**
 * @author chenmengliang
 * @date 2020/3/17 10:29
 * 300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 **/
public class _300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        _300_LongestIncreasingSubsequence longestIncreasingSubsequence = new _300_LongestIncreasingSubsequence();
        //System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        //System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{2, 2}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

    /**
     * 动态规划
     * dp[i]表示当前到第i个数（从0开始）为止，最长序列是多少
     * dp[i] = max(dp[k])+1  k = 0~i-1, 且nums[i]>=nums[k]
     * 每得到一个dp[i],更新一下最长上升子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 求的i前面，小于nums[i]的最大上升子序列的长度
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            // 算上自己
            dp[i] += 1;
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }
}
