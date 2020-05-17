import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2019/9/4 10:59
 * [141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
 **/
public class LinkedListCycle {
    public static void main(String[] args) {

        ListNode head = ListNode.createLinkListTailInsert(new int[]{3,2,0,-4});
        //common.ListNode head = common.ListNode.createLinkListTailInsert(new int[]{1});
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

        System.out.println(new LinkedListCycle().hasCycleDoublePointer(head));

    }

    /**
     * 算法一：
     * 将每个节点的地址和值存起来
     * 执行用时 : 16 ms, 在所有 Java 提交中击败了 7.26%的用户
     * 内存消耗 : 41.3 MB , 在所有 Java 提交中击败了17.46%的用户
     *
     * @param head
     * @return
     */
    private boolean hasCycleBySet(ListNode head) {
        ListNode p = head;
        //head.displayAllNodes();

        Set<ListNode> set = new HashSet<>();

        while (p != null) {
            //指回了以前的节点
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }

    /**
     * 算法二：
     * 双指针法 一个慢指针slow，一个快指针fast
     * slow每次走一步，fast每次走两步
     * 如果无环，fast肯定最先走到终点
     * 如果存在环，则fast走到头之后会返回回来走在slow的后面
     * a. 假如fast 离slow差1 则下次slow += 1 fast += 2 fast便于slow相遇
     * b. 假如fast 离slow差2 则下次slow += 1 fast += 2 fast便于slow差1 回到a情形
     * c. 假如fast 离slow差3 则下次slow += 1 fast += 2 fast便于slow差2 回到b情形
     * d. 假如fast 离slow差4 则下次slow += 1 fast += 2 fast便于slow差3 回到c情形
     * ...
     * 结论：只要fast在slow后面，slow先走，fast追赶，两者一定能相遇（不会存在fast直接越过slow的现象）
     *
     * @param head
     * @return
     */
    private boolean hasCycleDoublePointer(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && fast.next != null && slow!=null){

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }
}
