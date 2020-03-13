package CompanyExaminationBank.leetcode.Huawei;

/**
 * @author chenmengliang
 * @date 2020/3/12 19:08
 * 45. 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 **/
public class _45_JumpGameII {
    public static void main(String[] args) {
        _45_JumpGameII jumpGameII = new _45_JumpGameII();
        //System.out.println(jumpGameII.jump(new int[]{2, 3, 1, 1, 4}));
        //System.out.println(jumpGameII.jump(new int[]{1, 2, 3}));
        System.out.println(jumpGameII.jump(new int[]{3, 4, 3, 2, 5, 4, 3}));
        System.out.println(jumpGameII.jump(new int[]{10,1,1,1,1,1,1,1}));
    }

    /**
     * 贪心+动态规划：
     * 当前在i的位置，可跳nums[i]远，那么[i+1,i+nums[i]]都可以作为下次起跳的起点
     * 选在[i+1,i+nums[i]]中可以跳的最远的作为i之后的点，如果[i+1,i+nums[i]]区间内的值都一样，就选择最右边的点作为下次的起跳点
     * 如果发现已经可以跳到终点了，就立即返回
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int minJumpTimes = 0;

        // 每次起跳的起点，如果下次起跳的起点已经是 >= nums.length-1 就说明跳到最后了
        int start = 0;

        while (start < nums.length - 1) {

            // 在[start+1,start+nums[start]]的点中，可以跳到最远的那个index
            // 比如2 3 1 1 4，start==0时，可以跳到index=1，index=2处，
            // 其中index==1时，下一跳可以跳到1+3=4处，index==2时，下一跳可以跳到2+1=3处
            /// 所以在index=0处，选择下一跳跳在index=1处，以此类推，直到start>= nums.length-1，也就是已经跳到了最后
            int nextIndex = start+1;

            int end = start + nums[start];
            if (end >= nums.length - 1) {
                return minJumpTimes + 1;
            }
            // 找当前的这一跳中，能够跳的最远的
            for (int i = nextIndex; i <= end; i++) {
                if (nextIndex >= nums.length - 1) {
                    break;
                }
                nextIndex = (i + nums[i]) >= (nextIndex + nums[nextIndex]) ? i : nextIndex;
            }

            // 从start跳到nextIndex
            start = nextIndex;
            // 再跳一下，跳到maxJumpDistanceIndex处
            minJumpTimes++;
        }


        return minJumpTimes;
    }

    /**
     * dp[] 保存跳到当前所需要的最小的条数
     * 依次遍历nums[],跳到第i个位置时，更新当前位置的最小跳跃次数，
     * 并更新从i开始后面的nums[i-1]个位置的最小跳跃次数
     * 执行用时 : 604 ms, 在所有 Java 提交中击败了5.04%的用户
     * 内存消耗 : 40.8 MB, 在所有 Java 提交中击败了 6.45%的用户
     * 时间空间复杂度过高
     * @param nums
     * @return
     */
    @Deprecated
    public int jumpLongTime(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int len = nums.length;

        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            int step = nums[i];

            if (i + step >= len - 1) {
                return dp[i] + 1;
            }

            // 依次修改下一次能跳到的地方的最小跳数
            while (step > 0) {
                // 如果第一次走到这里，那最短路径就是上一步的 跳一下之后跳到这里
                // 否则就选择历史中最小的
                dp[i + step] = dp[i + step] == 0 ? dp[i] + 1 : Math.min(dp[i + step], dp[i] + 1);
                step--;
            }
        }

        return dp[len - 1];
    }
}
