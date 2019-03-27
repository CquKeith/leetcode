# -*- coding: UTF-8 -*-
# @Time             : 2019-03-18 21:29
# @Author           : Keith
# @File             : 9.回文数.py
# @Software         : PyCharm
# @About            :

class Solution:
    def isPalindrome(self,x:int) -> bool:

        # if x < 0:return False
        #
        # # isNegative = -1 if x < 0 else 1
        #
        # old = x
        # # x *= isNegative
        #
        # sum = 0
        # while x:
        #     sum = sum*10 + x % 10
        #     x //= 10
        # # sum *= isNegative
        #
        #
        # return sum == old

        return str(x) == str(x)[::-1]

if __name__ == '__main__':
    a = 121

    print(Solution().isPalindrome(a))
