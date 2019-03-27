# -*- coding: UTF-8 -*-
# @Time             : 2019-03-09 14:55
# @Author           : Keith
# @File             : 7.整数反转.py
# @Software         : PyCharm
# @About            :


def reverse(number):
    m = 2 << 31 - 1
    if number < -m or number > m:
        return 0

    sum = 0
    symbol = 1 if number > 0 else -1
    number = number * symbol #求绝对值
    while number != 0:
        sum = sum * 10 + number % 10
        number = number // 10
        # 检测反转的过程中有没有超过32位的表示范围
        if sum < -m or sum > m:
            return 0
    return sum * symbol


if __name__ == '__main__':
    a = int(input('please input an unsigned int 32:'))
    # print(a)
    print(reverse(a))
