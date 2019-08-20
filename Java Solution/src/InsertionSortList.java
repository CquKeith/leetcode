/**
 * @author Keith
 * @date 8/20/2019 15:04
 * leetcode 第147题 对链表进行插入排序
 **/
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode node = ListNode.createLinkListTailInsert(new int[]{-1, 5, 3, 4, 0,-2});
        new InsertionSortList().insertionSortList2(node).displayAllNodes();
    }

    /**
     * 方法二
     * 执行用时 : 9 ms,    在所有 Java 提交中击败了92.85% 的用户
     * 内存消耗 : 39.3 MB, 在所有 Java 提交中击败了33.63%  用户
     * 算法：新建一个带有头结点的链表，头结点取最小值，那么后面插入就肯定是往后面插了
     * @param head
     * @return
     */
    private ListNode insertionSortList2(ListNode head) {
        //只有0~1个节点，自然有序
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(Integer.MIN_VALUE);
        //!!!!!!至关重要，否则后面tail再怎么操作，newHead.next一直是空的
        newHead.next = head;
        //记录有序链表的尾节点，也就是当前最大的节点
        ListNode tail = newHead;


        while (head!=null){
            //当前节点比有序链表最大的节点 还大，则直接链到后面即可
            if (head.val > tail.val){
                tail = head;
            }
            else {//如若不是，则需要找出，当前节点需插入的位置
                ListNode p = newHead;
                while (p.next.val < head.val){
                    p = p.next;
                }
                //将当前节点插入到p节点之后
                tail.next = head.next;
                head.next = p.next;
                p.next = head;
            }
            head = tail.next;
        }
        return newHead.next;
    }


    /**
     * 方法一 执行用时 : 35 ms,    在所有 Java 提交中击败了54.81% 的用户
     *        内存消耗 : 39.6 MB, 在所有 Java 提交中击败了28.51%  用户
     *  算法：1.现摘除第一个节点
     *       2. 以此遍历原链表，一次摘除一个节点，然后将节点插入已经有序的链表中
     *          插入时有可能会插入到第一个节点之前，也有可能是其他位置
     * @param head
     * @return
     */
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
