# -*- coding: UTF-8 -*-
# @Time             : 2019-03-18 22:02
# @Author           : Keith
# @File             : 21.合并两个有序链表.py
# @Software         : PyCharm
# @About            :

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:

        if not l1: return l2
        if not l2: return l1

        p = l1

        while l2:
            if l2.val >= p.val:
                temp = ListNode(l2.val)
                temp.next = p.next
                p.next = temp
            else:

            p = p.next
            l2 = l2.next
        return l1


if __name__ == '__main__':
    a1 = ListNode(1)
    a2 = ListNode(2)
    a3 = ListNode(4)
    a1.next = a2
    a2.next = a3

    b1 = ListNode(1)
    b2 = ListNode(3)
    b3 = ListNode(4)
    b1.next = b2
    b2.next = b3

    result = Solution().mergeTwoLists(a1, b1)

    while result:
        print(result.val)
        result = result.next
