package Topic.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2019/9/23 16:11
 **/
public class BinaryTreeInOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{1, null, 2, 3});

        System.out.println(new BinaryTreeInOrderTraversal().inorderTraversalRecursive(root));
    }

    /**
     * 迭代算法  中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (null != p || !stack.isEmpty()) {
            //找到没有左孩子的节点
            while (null != p) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            ans.add(p.val);
            p = p.right;
        }
        return ans;
    }

    /**
     * 递归的方法 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    /**
     * @param root
     * @param list
     */
    private void helper(TreeNode root, List<Integer> list) {
        if (null != root) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

}
