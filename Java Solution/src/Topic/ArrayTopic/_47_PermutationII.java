package Topic.ArrayTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2020/3/1 19:06
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 **/
public class _47_PermutationII {

    private List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {

        _47_PermutationII solution = new _47_PermutationII();

        System.out.println(solution.permuteUnique(new int[]{3,3,0,3}));
        //System.out.println(solution.permuteUnique(new int[]{0,3,3,3}));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0) {
            return ans;
        }
        // 排序之后 才能剪枝
        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        dfsWithPrune(nums, 0, visited, new ArrayList<>(nums.length));

        return ans;
    }

    /**
     * 在结果中直接去重
     *
     * @param nums                   原数组
     * @param depth                  当前遍历到的深度
     * @param visited                nums中的每个数在currentPermutationList是否出现过
     * @param currentPermutationList 当前遍历路径上 已经遍历到的数
     */
    public void dfs(int[] nums, int depth, boolean[] visited, List<Integer> currentPermutationList) {

        // 如果已经遍历到了最深层，也就是遍历完了一遍了
        if (depth == nums.length) {
            if (!ans.contains(currentPermutationList)) {
                ans.add(new ArrayList<>(currentPermutationList));
            }
            return;
        }
        // 如果还没遍历完
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                currentPermutationList.add(nums[i]);
                visited[i] = true;

                dfs(nums, depth + 1, visited, currentPermutationList);

                currentPermutationList.remove(depth);
                visited[i] = false;
            }
        }
    }

    /**
     * 回溯 + 剪枝
     * 出现重复的序列，主要是因为以下原因造成的：
     * 当前要准备开始的元素，等与上个刚刚恢复的元素
     * 比如 1 1 2 ，当遍历完1 1 2这个序列之后，回溯。从第二个1开始，那么就和前面的一样了
     *
     * @param nums
     * @param depth
     * @param visited
     * @param currentPermutationList
     */
    public void dfsWithPrune(int[] nums, int depth, boolean[] visited, List<Integer> currentPermutationList) {

        if (depth == nums.length) {
            ans.add(new ArrayList<>(currentPermutationList));
            return;
        }
        int pre = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            // 剪枝
            if (pre == nums[i]) {
                continue;
            }

            pre = nums[i];

            currentPermutationList.add(nums[i]);
            visited[i] = true;

            dfsWithPrune(nums, depth + 1, visited, currentPermutationList);

            currentPermutationList.remove(depth);
            visited[i] = false;
        }

    }
}
