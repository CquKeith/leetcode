# -*- coding: UTF-8 -*-
# @Time             : 2019-03-18 11:29
# @Author           : Keith
# @File             : 344.反转字符串.py
# @Software         : PyCharm
# @About            :


class Solution:
    def reverseString(self, s:str) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        #  方法一 耗时多
        lenth = len(s)
        for i in range(lenth // 2):
            s[i], s[lenth - 1 - i] = s[lenth - 1 - i],s[i]
        print(s)






if __name__ == '__main__':
    Solution().reverseString(list("hello"))