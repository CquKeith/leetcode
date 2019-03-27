# -*- coding: UTF-8 -*-
# @Time             : 2019-03-25 21:01
# @Author           : Keith
# @File             : 33.搜索旋转排序数组.py
# @Software         : PyCharm
# @About            :

class Solution:
    def search(self, nums: list, target: int) -> int:
        index = -1




        for i in range(len(nums)):
            if nums[i] == target:
                index = i
                break
        return index


if __name__ == '__main__':
    a = [4,5,6,7,0,1,2]
    target = 0
    print(Solution().search(a,target))