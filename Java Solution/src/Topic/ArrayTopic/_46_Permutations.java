package Topic.ArrayTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2020/2/29 15:56
 * https://leetcode-cn.com/problems/permutations/
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 **/
public class _46_Permutations {

    private List<List<Integer>> ans = new ArrayList<>();


    public static void main(String[] args) {
        _46_Permutations permutations = new _46_Permutations();

        System.out.println(permutations.permute(new int[]{1,2,3}));
        //System.out.println(permutations.permute(new int[]{1,1,2}));

    }

    /**
     * 全排列
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums){

        int len = nums.length;
        if (len == 0){
            return ans;
        }

        boolean[] used = new boolean[len];

        dfs(nums,len,0,used,new ArrayList<>());

        return ans;
    }

    /**
     *
     * @param nums 数组
     * @param len nums的长度
     * @param depth 当前DFS的深度
     * @param used nums中每个数在 currentPermutationList中是否已经出现过
     * @param currentPermutationList 当前路径上的排列的数组
     */
    private void dfs(int[] nums, int len, int depth, boolean[] used, ArrayList<Integer> currentPermutationList) {

        if (len == depth) {
            ans.add(new ArrayList<>(currentPermutationList));
            return;
        }
        // 遍历多有 未被访问过的节点
        for (int i = 0; i < len; i++) {
            if (!used[i]) {

                // 加入当前节点
                currentPermutationList.add(nums[i]);
                // 标记当前节点 已经访问过
                used[i] = true;

                // 递归遍历余下的节点
                dfs(nums,len,depth+1,used,currentPermutationList);

                // 如果已经执行到此，说明上面的dfs已经执行完，也就是ans中已经添加了currentPermutationList的拷贝
                // 现在逐层递归返回，将现在的节点以此移除，并标记为未使用，以便再次使用该节点
                currentPermutationList.remove(depth);
                used[i] = false;
            }
        }

    }

    /**
     *
     * @param currentPermutationList 当前已经有的序列
     * @param index 当前已经遍历到nums的第几个数
     * @param nums
     */
    @Deprecated
    public void backTrace(List<Integer> currentPermutationList,int index,int[] nums){

        // 如果已经遍历到了最后一个数字
        if (index == nums.length){
            ans.add(new ArrayList<>(currentPermutationList));
            return;
        }
        //
        for (int i = index; i < nums.length; i++) {
            currentPermutationList.add(nums[index]);
            backTrace(currentPermutationList,i+1,nums);
        }

    }
}
