package CompanyExaminationBank.leetcode.Huawei;

import java.util.LinkedList;

/**
 * @author chenmengliang
 * @date 2020/3/16 22:28
 * 55. 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 **/
public class _55_JumpGame {
    public static void main(String[] args) {
        _55_JumpGame jumpGame = new _55_JumpGame();
        //System.out.println(jumpGame.canJump(new int[]{2, 3, 1, 1, 4}));
        //System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(jumpGame.canJump(new int[]{0}));

    }

    /**
     * 贪心算法
     * 每次尽最大努力跳，看看跳的最远的地方在哪儿
     * 尽最大努力意思是：
     *  比如2，3，1，4.
     *      在2处,可以跳到3，1两处，但是跳到3处，比跳大1处，在下一次的跳跃中跳得远，
     *      所以跳到3处
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        if (null == nums || nums.length <= 0) {
            return false;
        }

        // 当前能跳到的最远的地方
        int currentMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前在i节点，结果最远才能跳到i之前，说明肯定跳不到最后了
            // 比如0，2 当i==1时，currentMaxIndex == 0,说明肯定跳不过了
            if (i > currentMaxIndex) {
                return false;
            }
            currentMaxIndex = Math.max(currentMaxIndex, i + nums[i]);
        }
        // 如果可以成功遍历到nums的结尾，则寿命已经跳到了
        return true;
    }

    /**
     * 层次遍历：
     *  首先，将第一个节点入队
     *  然后在队列不为空的时候，循环
     *      队头出对，然后将它能够跳到的index入队
     *      队头出对时，判断当前index距离target是否小于nums[index]，小于，说明现在就可以跳过去
     * @param nums
     * @return
     * 超时
     */
    @Deprecated
    public boolean canJumpLevelTraversal(int[] nums) {
        if (null == nums || nums.length <= 0) {
            return false;
        }

        // 目标index
        int target = nums.length - 1;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int currentIndex = queue.removeFirst();
            if (currentIndex < nums.length && target - currentIndex <= nums[currentIndex]) {
                return true;
            }
            for (int i = 1; i <= nums[currentIndex]; i++) {
                queue.addLast(i + currentIndex);
            }
        }
        return false;
    }

}
