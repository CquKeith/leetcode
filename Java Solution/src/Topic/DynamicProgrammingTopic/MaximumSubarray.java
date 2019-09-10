package Topic.DynamicProgrammingTopic;

/**
 * @author chenmengliang
 * @date 2019/9/5 11:19
 * [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
 **/
public class MaximumSubarray {
    public static void main(String[] args) {

        //System.out.println(new MaximumSubarray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new MaximumSubarray().maxSubArray(new int[]{-1}));

    }

    /**
     * f(k) 记为前k个数（从1开始计数）的最大连续子序和
     * A(i) 记为第i个数的值
     * f(n) = f(n-1)<0?A(n):f(n-1)+A(n)
     * @param nums
     * @return 最大的连续子序列的和
     */
    private int maxSubArray(int[] nums) {

        int length = nums.length;
        int[] dp = new int[length+1];
        dp[0] = 0;

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i-1]<0?nums[i-1]:dp[i-1] + nums[i-1];
            ans = ans < dp[i]?dp[i]:ans;

        }
        //System.out.println(Arrays.toString(dp));
        return ans;
    }
}
