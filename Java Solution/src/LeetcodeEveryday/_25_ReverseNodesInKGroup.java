package LeetcodeEveryday;


import common.ListNode;

/**
 * @author chenmengliang
 * @date 2020/5/16 18:39
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 **/
public class _25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        int k = 2;
        _25_ReverseNodesInKGroup reverseNodesInKGroup = new _25_ReverseNodesInKGroup();
        ListNode head = ListNode.createLinkListTailInsert(new int[]{1, 2, 3, 4, 5});
        head = reverseNodesInKGroup.reverseKGroup(head, k);
        head.displayAllNodes();
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;

        int i = 0;
        while (i < k && null != p) {

            i++;
            if (i == k) {
                i = 0;
            }
            p = p.next;
        }

        return head;
    }
}