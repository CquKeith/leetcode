/**
 * @author Keith
 * @date 8/20/2019 14:43
 **/
public class MergeTwoSortedLists {
    public static void main(String args[]){

        ListNode l1 = ListNode.createLinkListTailInsert(new int[]{1,2,4});
        ListNode l2 = ListNode.createLinkListTailInsert(new int[]{1,3,4});

        new MergeTwoSortedLists().mergeTwoLists(l1,l2).displayAllNodes();
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //先判空
        if (l1==null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //带有头结点的链表
        ListNode head = new ListNode(0);
        //尾节点
        ListNode tail = head;

        //循环摘取一个节点链在结果链表上
        while (l1!= null && l2!=null){
            if (l1.val < l2.val){
                tail.next = l1;

                l1 = l1.next;

            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null){
            tail.next = l2;
        }
        if (l2==null){
            tail.next = l1;
        }


        return head.next;
    }
}
