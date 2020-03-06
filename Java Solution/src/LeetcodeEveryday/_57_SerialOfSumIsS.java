package LeetcodeEveryday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2020/3/6 15:17
 * 面试题57 - II. 和为s的连续正数序列
 * https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 * 1 <= target <= 10^5
 **/
public class _57_SerialOfSumIsS {
    public static void main(String[] args) {
        _57_SerialOfSumIsS serialOfSumIsS = new _57_SerialOfSumIsS();
        System.out.println(Arrays.deepToString(serialOfSumIsS.findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(serialOfSumIsS.findContinuousSequence(15)));
    }

    /**
     * 从i开始，k个连续数的和是
     * Sum(i,i+1,i+2,...,i+k-1) = ki + k(k-1)/2
     * 滑动窗口[i,j）
     * 初始值i=1，j=1,窗口增大：j++，窗口减小：i++，直到i>j
     * sum([i,j)) < target ，窗口右移
     * sum([i,j)) = target ，记录当前窗口对应的连续序列，并++i
     * sum([i,j)) > target ，窗口左移(--j)
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> tempList = new ArrayList<>();

        int left = 1;
        // 获取当前sum([left,right)) <= target的最大right
        int right = 1;
        // left!=target 是为了排除target=left，连续序列只有一个数的情况
        while (left <= right && left!=target) {
            int sum = calcContinuousSequenceSum(left, right);
            if (sum == target) {
                // 添加当前序列
                int[] temp = new int[right - left];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                tempList.add(temp);

                // 窗口右移
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }

        return tempList.toArray(new int[0][]);
    }

    /**
     * sum([left,right))<=target 的最大的right值
     * （left+(right-1)）*(right-left)/2<=target
     *  ==> j <= 0.5+sqrt(2n+i*i+i+0.25)
     * @param left
     * @param target
     * @return
     */
    @Deprecated
    private int getInitRight(int left, int target) {
        return (int) Math.floor(0.5 + Math.sqrt(2 * target + left * left + left + 0.25));
    }

    /**
     * 等差数列求和[start,end),公差是1
     * @param start
     * @param end
     * @return
     */
    public int calcContinuousSequenceSum(int start, int end) {
        return (start + end-1) * (end - start) / 2;
    }
}
