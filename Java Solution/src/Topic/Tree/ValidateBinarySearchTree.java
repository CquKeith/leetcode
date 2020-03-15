package Topic.Tree;

import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2019/9/23 19:40
 * 华为面试题
 * 判断一棵树 是否为BST
 **/
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{1, null, 2, 3});
        System.out.println(new ValidateBinarySearchTree().isValidBST(root));
    }

    /**
     * 中序遍历
     * 发现逆序（前面的数比后面的大），就false
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {


        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //int lastValue = Integer.MIN_VALUE;
        //此处不能是int ， 因为如果只有一个跟节点 值是Integer.MIN_VALUE,那结果本来应该是true，便会输出false来
        long lastValue = Long.MIN_VALUE;
        while (null != p || !stack.isEmpty()){
            while (null != p){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if (lastValue >= p.val){
                return false;
            }
            lastValue = (long) p.val;
            p = p.right;
        }
        return true;
    }

}
