package Topic.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenmengliang
 * @date 2020/3/15 14:33
 * 102. 二叉树的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 **/
public class _102_BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        _102_BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new _102_BinaryTreeLevelOrderTraversal();

        TreeNode root = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});

        System.out.println(binaryTreeLevelOrderTraversal.levelOrder(root));
    }

    /**
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (null == root) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int index = 0;
            List<Integer> currentLevelList = new ArrayList<>(levelSize);
            while (index < levelSize) {
                TreeNode node = queue.poll();
                currentLevelList.add(node.val);
                index++;
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            // 每次扫描完一层，加入ans，防止重复添加
            ans.add(currentLevelList);
        }

        return ans;
    }
}
