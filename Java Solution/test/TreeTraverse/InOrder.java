package TreeTraverse;

import Topic.Tree.TreeNode;

import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2019/11/22 22:14
 **/
public class InOrder {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{1,2,3,4,5,6,7});

        inOrderRecursive(root);
        System.out.println();
        inOrderNotRecursive(root);

    }

    /**
     * 递归中序遍历
     * @param root
     */
    public static void inOrderRecursive(TreeNode root){
        if (null != root){
            inOrderRecursive(root.left);
            System.out.print(root.val+" ");
            inOrderRecursive(root.right);
        }
    }

    /**
     * 非递归中序遍历
     * 借助栈，找到最左边的叶子节点之后，将上一层弹出，然后访问右节点
     * @param root
     */
    public static void inOrderNotRecursive(TreeNode root){

        if (null == root)return;

        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;//当前节点不为空，就往左走
            }else{// 遇到叶子节点了
                root = stack.pop();
                System.out.print(root.val+" ");
                root = root.right;//往右走
            }
        }
    }
}
