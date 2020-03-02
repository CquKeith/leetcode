package Topic.ArrayTopic;

import java.util.*;

/**
 * @author chenmengliang
 * @date 2020/3/2 12:27
 * https://leetcode-cn.com/problems/combination-sum/
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * <p>
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * <p>
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 **/
public class _39_CombinationSum {

    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        _39_CombinationSum solution = new _39_CombinationSum();
        //System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,5},8));
    }

    /**
     * 回溯 + 剪枝（去重）
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates.length == 0){
            return ans;
        }

        // 先排序
        Arrays.sort(candidates);

        dfs(candidates, target,0, new Stack<>());

        return ans;

    }

    /**
     * 规定本次的起点 是为了去重
     * 比如candidates = {2,3,5},target = 7
     * 第一次得到序列2 2 3。
     * 回溯到2之后，选择了3，3在candidates中的的index是1，如果此时还从0开始，就会选中candidates[0] = 2这个数
     * 就会和第一个序列重复。因此2，3之后，应该从index = 1（也就是3在candidates中的index）开始，才能避免重复
     * 注意：这种方法要注意，candidates一定是有序的才可以！！！！！！
     * @param candidates 候选数（有序的）
     * @param target 本次的目标值
     * @param begin 下次的起点
     * @param currentCombinationList 当前序列
     */
    private void dfs(int[] candidates, int target, int begin,Stack<Integer> currentCombinationList) {

        // target 已经被减到小于0的时候，说明candidates中没有适合当前序列的下一个值，使得序列的和等于target了
        if (target < 0) {
            return;
        }
        // 如果已经被减到0了，那么说明已经凑齐了
        if (target == 0) {
            ans.add(new ArrayList<>(currentCombinationList));
            return;
        }

        // 如果target 还不为0，那么肯定还可以继续分解

        for (int i = begin; i < candidates.length; i++) {
            int candidate = candidates[i];

            // 如果target 已经小到比第一个（candidates最小的）还要小，那么后面就不用试了
            if (target < candidate) {
                return;
            }

            currentCombinationList.push(candidate);

            dfs(candidates, target - candidate,i, currentCombinationList);

            currentCombinationList.pop();
        }

    }
}
