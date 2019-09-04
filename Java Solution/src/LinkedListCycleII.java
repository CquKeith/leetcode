import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2019/9/4 10:59
 * [142. 环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/)
 **/
public class LinkedListCycleII {
    public static void main(String[] args) {

        ListNode head = ListNode.createLinkListTailInsert(new int[]{3, 2, 0, -4});
        //ListNode head = ListNode.createLinkListTailInsert(new int[]{1});
        //ListNode head = ListNode.createLinkListTailInsert(new int[]{1,2});
        //尾节点的next 指向第几个节点 -1代表null，节点index从0开始
        int pos = 1;
        ListNode posNode = null, p = head;
        int i = 0;

        while (p.next != null) {
            if (i++ == pos) {
                posNode = p;
            }
            p = p.next;
        }
        p.next = posNode;

        System.out.println(new LinkedListCycleII().detectCycle(head));

    }

    /**
     * 算法一：
     *      借助Set
     *      执行用时 :16 ms, 在所有 Java 提交中击败了25.39%的用户
     *      内存消耗 :36.4 MB, 在所有 Java 提交中击败了 5.03%的用户
     * @param head
     * @return
     */

    private ListNode detectCycleBySet(ListNode head){
        ListNode p = head;
        Set<ListNode> set = new HashSet<>();
        while (p!=null){
            if (set.contains(p)){
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }

    /**
     * 算法二：分两阶段
     *      1. 快慢指针 找相遇点
     *      2. 从头开始走，另一方面相遇点也继续往前走，两者相遇的点就是环开始的地方
     *
     * @param head
     * @return
     */
    private ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        //相遇点
        ListNode meetNode = null;


        while (fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                meetNode = slow;
                break;
            }
        }
        //未相遇 -> 无环
        if (null == meetNode){
            return null;
        }
        //有环 找环开始的节点
        //解析和公式：
        //https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/

        ListNode p = head;
        while (p!=meetNode){
            p = p.next;
            meetNode = meetNode.next;
        }
        return p;

    }

}
