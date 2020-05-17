import common.ListNode;

/**
 * @author Keith
 * @date 2019/8/6 18:28
 **/
public class AddTwoNumbers {
    public static void main(String[] args) {

        //初始化第1个链表
        ListNode firstLinkList = ListNode.createLinkListTailInsert(new int[]{1,2,3,4,5});
        assert firstLinkList != null;
        firstLinkList.displayAllNodes();
        System.out.println();
        //初始化第2个链表
        ListNode secondLinkList = ListNode.createLinkListTailInsert(new int[]{5});
        assert secondLinkList != null;
        secondLinkList.displayAllNodes();
        System.out.println();

        addTwoNumbers(firstLinkList, secondLinkList).displayAllNodes();


    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        // 进位
        int carry = 0;

        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        //计算l1 l2 的贡献
//        try {
//            carry += l1.val + l2.val;
//            l1 = l1.next;
//            l2 = l2.next;
//        } catch (NullPointerException e) {
//
//        }
        while (l1 != null || l2 != null || carry!=0) {


            //计算l1 的贡献
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            ListNode node = new ListNode(carry % 10);
            //更新进位
            carry /= 10;

            //将节点插入结果链表尾
           tail.next = node;
           tail = node;
        }


        //带有头结点的链表，头结点不存值
        return result.next;
    }
}

/**
 * 链表节点类
 */
//class common.ListNode {
//
//
//    int val;
//    common.ListNode next = null;
//
//    common.ListNode(int x) {
//        val = x;
//    }
//
//
//    void displayAllNodes() {
//        common.ListNode node = this;
//        while (node != null) {
//            System.out.print(node.val + "  ");
//            node = node.next;
//        }
//    }
//
//    static common.ListNode createLinkListHeadInsert(int[] nums) {
//        if (nums.length < 1) {
//            return null;
//        }
//        common.ListNode head = new common.ListNode(nums.length);
//        for (int num : nums) {
//            common.ListNode node = new common.ListNode(num);
//            node.next = head.next;
//            head.next = node;
//        }
//        return head.next;
//    }
//    static common.ListNode createLinkListTailInsert(int[] nums) {
//        if (nums.length < 1) {
//            return null;
//        }
//        common.ListNode head = new common.ListNode(nums.length);
//        //尾节点
//        common.ListNode tail = head;
//        for (int num : nums) {
//            common.ListNode node = new common.ListNode(num);
//            tail.next = node;
//            tail = node;
//        }
//        return head.next;
//    }
//
//
//
//}
