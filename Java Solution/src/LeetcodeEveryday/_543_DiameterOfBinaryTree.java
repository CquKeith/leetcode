package LeetcodeEveryday;

import Topic.Tree.TreeNode;

/**
 * @author chenmengliang
 * @date 2020/3/11 12:24
 * 543. 二叉树的直径
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 **/
public class _543_DiameterOfBinaryTree {

    private int ans = 0;

    public static void main(String[] args) {
        _543_DiameterOfBinaryTree diameterOfBinaryTree = new _543_DiameterOfBinaryTree();
        //TreeNode root = TreeNode.createTree(new Integer[]{1,2,3,4,5});
        TreeNode root = TreeNode.createTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2});
        TreeNode.levelTraversal(root);

        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }



    /**
     * 二叉树的直径，等于最长路径上的节点数-1
     * 以Root为根的二叉树，左子树的最大深度为L，右子树的最大深度为R，则以Root为根的树最长路径是L+R
     * 而左子树Left的最大深度等于Left的左右子树中最大的深度
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        depthOfBinaryTree(root);

        return ans;
    }

    /**
     *
     * @param root
     * @return 二叉树root的深度
     */
    public int depthOfBinaryTree(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = depthOfBinaryTree(root.left);
        int rightDepth = depthOfBinaryTree(root.right);

        // 更新最长路径
        ans = Math.max(ans, leftDepth + rightDepth);

        return Math.max(leftDepth, rightDepth) + 1;
    }


}
