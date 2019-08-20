/**
 * @author Keith
 * @date 8/20/2019 10:42
 **/
public class RemoveNthNodeFromEndOfList {
    public static void main(String args[]) {
        ListNode head = ListNode.createLinkListTailInsert(new int[]{1,2,3,4,5});

        new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 6).displayAllNodes();
    }


    private ListNode removeNthFromEnd(ListNode head, int n) {
        //工作指针
        ListNode p = head;
        //指向倒数第n个节点
        ListNode q = head;
        //q的前置节点
        ListNode pre = null;

        //p q之间的距离
        int idx = 0;
        while (p != null){
            idx++;
            //p 先往前走idx步
            p = p.next;
            if (idx  > n){
                pre = q;
                q = q.next;
            }
        }

        if (idx < n) {
            return head;
        }
        //删除q所在的节点
        //情况1 删除的是头结点
        if (pre == null){
            head = head.next;
            q = null;
        }else {
            pre.next = q.next;
            q = null;
        }


        return head;
    }
}
