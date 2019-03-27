# -*- coding: UTF-8 -*-
# @Time             : 2019-03-16 21:33
# @Author           : Keith
# @File             : 2.两数相加.py
# @Software         : PyCharm
# @About            :

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        result = head
        carry = 0  # 是否有进位

        if l1 == None: return l2
        if l2 == None: return l1

        while l1 or l2:
            # l1Value = 0 if not l1 else l1.val
            # l2Value = 0 if not l2 else l2.val

            cur = ListNode(carry)
            if l1:
                cur.val += l1.val
                l1 = l1.next
            if l2:
                cur.val += l2.val
                l2 = l2.next
            #
            # sum = l1Value + l2Value + carry
            # sum = l1.val + l2.val + carry

            carry = cur.val // 10
            cur.val %= 10

            result.next = cur
            result = result.next
            # l1 = l1.next if l1 else None
            # l2 = l2.next if l2 else None
            # l1 = l1.next
            # l2 = l2.next

        # 两个位数不一样的
        # if not l1 and l2: result.next = l2
        # if not l2 and l1: result.next = l1

        # 两个位数一样的  加完了
        if carry > 0:
            result.next = ListNode(carry)

        return head.next


if __name__ == '__main__':
    a1 = ListNode(2)
    a2 = ListNode(4)
    a3 = ListNode(3)
    a1.next = a2
    a2.next = a3

    b1 = ListNode(5)
    b2 = ListNode(6)
    b3 = ListNode(4)
    b1.next = b2
    b2.next = b3

    # a1 = ListNode(9)
    # a2 = ListNode(8)
    # a1.next = a2
    #
    # b1 = ListNode(1)

    add_sum = Solution().addTwoNumbers(a1, b1)

    while add_sum != None:
        print(add_sum.val)
        add_sum = add_sum.next
