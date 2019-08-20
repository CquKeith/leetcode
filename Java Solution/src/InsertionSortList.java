/**
 * @author Keith
 * @date 8/20/2019 15:04
 * leetcode 第147题 对链表进行插入排序
 **/
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode node = ListNode.createLinkListTailInsert(new int[]{-1, 5, 3, 4, 0,-2});
        new InsertionSortList().insertionSortList(node).displayAllNodes();
    }


    private ListNode insertionSortList(ListNode head) {

        //只有0~1个节点，自然有序
        if (head == null || head.next == null) {
            return head;
        }
        //摘下第一个节点
        ListNode ans = null;
//        head = head.next;
//        ans.next = null;

        while (head != null) {
            ListNode p = ans;
            ListNode pre = null;
            //找到第一个 大于等于 head.val 的值，插在他的前面
            while (p != null && p.val < head.val) {
                pre = p;
                p = p.next;
            }
            //取下未排序链表中的第一个节点
            ListNode temp = head;
            head = head.next;
            temp.next = null;

            //插在当前有序链表的头
            if (pre == null) {
                temp.next = ans;
                ans = temp;
            } else {
                temp.next = p;
                pre.next = temp;
            }
        }
        return ans;
    }
}
