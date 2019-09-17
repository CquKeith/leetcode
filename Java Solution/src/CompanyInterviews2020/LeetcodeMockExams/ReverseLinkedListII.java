package CompanyInterviews2020.LeetcodeMockExams;

/**
 * @author chenmengliang
 * @date 2019/9/4 16:42
 * 92. 反转链表 II
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/submissions/
 **/
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = ListNode.createLinkListTailInsert(new int[]{1,2,3,4,5});
        new ReverseLinkedListII().reverseBetween(head,1,4).displayAllNodes();
    }

    /**
     * 反转链表 下标[m,n]的部分，下标从1开始
     * 一趟扫描完成
     * @param head
     * @param m
     * @param n
     * @return
     */
    private ListNode reverseBetween(ListNode head, int m, int n) {

        if (null == head){
            return head;
        }

        int index = 1;
        ListNode p = head;
        ListNode pre = null;
        //找头
        while (index < m){
            pre = p;
            p = p.next;
            index++;
        }
        //逆制
        while (index < n){
            ListNode node = p.next;

            p.next = node.next;

            if (null != pre){
                node.next = pre.next;
                pre.next = node;
            }else {
                node.next = head;
                head = node;
            }

            index++;
        }

        return head;

    }
}
/**
 * 链表节点类
 */
class ListNode {


    int val;
    ListNode next = null;

    ListNode(int x) {
        val = x;
    }


    void displayAllNodes() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }

    static ListNode createLinkListHeadInsert(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        ListNode head = new ListNode(nums.length);
        for (int num : nums) {
            ListNode node = new ListNode(num);
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }
    static ListNode createLinkListTailInsert(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        ListNode head = new ListNode(nums.length);
        //尾节点
        ListNode tail = head;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }



}
