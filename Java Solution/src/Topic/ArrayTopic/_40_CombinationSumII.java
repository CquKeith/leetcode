package Topic.ArrayTopic;

import java.util.*;

/**
 * @author chenmengliang
 * @date 2020/3/2 14:04
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 **/
public class _40_CombinationSumII {
    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        _40_CombinationSumII solution = new _40_CombinationSumII();
        System.out.println(solution.combinationUnique(new int[]{10,1,2,7,6,1,5},8));
    }

    /**
     * 比如 candidates = {10,1,2,7,6,1,5}，target = 8
     * 排序后 candidates = {1,1,2,5,6,7,10}
     * 第一个1用过之后，后面的1也不能用了，否则会出现重复的（把第一个1和第二个1看成是不同的1了）
     * @param candidates 候选数 不能被重复使用
     * @param target
     * @return
     */
    public List<List<Integer>> combinationUnique(int[] candidates,int target) {
        if (candidates.length == 0) {
            return ans;
        }
        // 排序，方便剪枝
        Arrays.sort(candidates);

        bfsUnique(candidates, target, 0, new Stack<Integer>());

        return ans;
    }

    /**
     * @param candidates
     * @param target
     * @param begin
     * @param currentCombinationList
     */
    private void bfsUnique(int[] candidates, int target, int begin, Stack<Integer> currentCombinationList) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(currentCombinationList));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            int candidate = candidates[i];

            // 如果target比最小的还小，则接下来肯定找不到合适的候选数来满足条件
            if (target - candidate < 0) {
                return;
            }

            // 如果当前candidate跟上一个candidate相等，则跳过本次
            // i>begin而不是i>0，是因为i>begin一定能满足i>0：begin最小是0，i>begin则i最小是1
            // 此外，i如果只是大于0,则会剪去所有相邻的值，比如8=1+1+6，前面是两个1，就会被剪去。
            // 相反，如果是i>begin,说明只有本次之后的，再出现相同才会被剪枝
            if (i > begin && candidate == candidates[i-1]){
                continue;
            }

            currentCombinationList.push(candidate);

            // 因为元素不可重复使用，因此begin要传i+1，而不是i
            bfsUnique(candidates, target - candidate,i+1, currentCombinationList);

            currentCombinationList.pop();
        }

    }
}
