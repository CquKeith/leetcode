package Topic.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, null, 3, 4, 5, 6, 7, 8};
        TreeNode root = createTree(nums);

        levelTraversal(root);

    }

    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    public static void levelTraversal(TreeNode root) {
        // 辅助队列
        Queue<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode currentNode = deque.poll();
            if (null != currentNode) {
                list.add(currentNode.val);
                if (null != currentNode.left) {
                    deque.add(currentNode.left);
                }
                if (null != currentNode.right) {
                    deque.add(currentNode.right);
                }

            } else {
                list.add(null);
            }

        }

        System.out.println(list);
    }

    public static TreeNode createTree(Integer[] data) {
        if (data.length <= 0) {
            return null;
        }

        TreeNode root = new TreeNode(data[0]);
        TreeNode currentNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < data.length) {
            int size = queue.size();
            while (size > 0) {
                currentNode = queue.poll();
                if (index < data.length && data[index] != null) {
                    currentNode.left = new TreeNode(data[index]);
                    queue.add(currentNode.left);
                }
                index++;
                if (index < data.length && data[index] != null) {
                    currentNode.right = new TreeNode(data[index]);
                    queue.add(currentNode.right);
                }
                index++;

                size--;
            }



        }

        return root;
    }

    /**
     * 根据数组（层次遍历的顺序）构建一棵树
     * 此方法弃用，因为要输入是满二叉树才可以，也就是说空节点的孩子节点也要输入（也是null）
     * @param data
     * @param index 当前从data数组的第一个开始
     * @return root
     */
    @Deprecated
    private static TreeNode createTree(Integer[] data, int index) {
        if ((index >= data.length) || null == data[index]) {
            return null;
        }

        TreeNode root = new TreeNode(data[index]);

        root.left = createTree(data, (index << 1) + 1);
        root.right = createTree(data, (index << 1) + 2);

        return root;
    }
}
