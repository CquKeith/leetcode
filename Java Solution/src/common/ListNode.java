package common; /**
 * @author chenmengliang
 * @date 2020/5/16 18:42
 **/
/**
 * 链表节点类
 */
public class ListNode {


    public int val;
    public ListNode next = null;

    public ListNode(int x) {
        val = x;
    }


    public void displayAllNodes() {
        ListNode node = this;
        while (node != null) {
            System.out.print(node.val + "  ");
            node = node.next;
        }
    }

    public static ListNode createLinkListHeadInsert(int[] nums) {
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
    public static ListNode createLinkListTailInsert(int[] nums) {
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
