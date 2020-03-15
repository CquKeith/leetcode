package Topic.Tree;

/**
 * @author chenmengliang
 * @date 2019/11/22 10:48
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 **/
public class _110_BalancedBinaryTree {
    public static void main(String[] args) {

        //TreeNode root = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        TreeNode root = TreeNode.createTree(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4});

        System.out.println(isBalanced(root));
    }

    /**
     * @param root
     * @return 广度优先遍历
     * 每一次遍历到叶子节点，得到一个深度，比较最大的深度和最小的深度，是否差值大于1
     * 如果大于1，则不是balanced
     */

    public static boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == -1 || rightDepth == -1) {
            return false;
        }
        return Math.abs(leftDepth - rightDepth) <= 1 && (isBalanced(root.left) && isBalanced(root.right));
    }

    /**
     * @param root
     * @return 以root的父节点的子树平衡，就返回深度，否则返回-1
     */
    public static int depth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

}
