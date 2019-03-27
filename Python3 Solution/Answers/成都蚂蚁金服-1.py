# -*- coding: UTF-8 -*-
# @Time             : 2019-03-22 11:20
# @Author           : Keith
# @File             : 成都蚂蚁金服-1.py
# @Software         : PyCharm
# @About            :

def maxSum(nums: list):
    start = 0
    end = 0

    max = 0

    currentSum = 0

    for i in range(len(nums)):
        currentSum += nums[i]

        if currentSum < 0:
            currentSum = 0
            start = i + 1
        else:
            if currentSum > max:
                max = currentSum
                end = i

    print(start, end, max)


if __name__ == '__main__':
    nums = [-2,1,-3,4,-1,2,1,-5,4]
    maxSum(nums)
