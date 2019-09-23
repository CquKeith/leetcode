package Topic.Tree;

/**
 * @author chenmengliang
 * @date 2019/9/12 09:42
 * [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)
 **/
public class SameTree {
    public static void main(String[] args) {

        TreeNode p = TreeNode.createTree(new int[]{1, 2});
        TreeNode q = TreeNode.createTree(new int[]{1, Integer.MIN_VALUE, 2});

        System.out.println(new SameTree().isSameTree(p, q));

    }

    /**
     * 层次遍历每棵树，没有左孩子就存入null，右孩子同理
     * 然后比较
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //两个都为null
        if (null == p && null == q) {
            return true;
        }
        //上面的没返回 说明下面的判断是  只有其中一个不为null
        if (null == p || null == q) {
            return false;
        }

        //两个都不为null 就判断值
        if (p.val != q.val) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    static TreeNode createTree(int[] data) {
        if (data.length <= 0) {
            return null;
        }
        TreeNode root = new TreeNode(data[0]);
        for (int i = 1; i < data.length; i++) {

            root.left = data[i] == Integer.MIN_VALUE ? null : new TreeNode(data[i]);
            if (++i < data.length) {
                root.right = data[i] == Integer.MIN_VALUE ? null : new TreeNode(data[i]);
            }
        }
        return root;
    }
}