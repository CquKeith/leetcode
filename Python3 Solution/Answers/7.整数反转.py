# -*- coding: UTF-8 -*-
# @Time             : 2019-03-09 14:55
# @Author           : Keith
# @File             : 7.整数反转.py
# @Software         : PyCharm
# @About            :


def reverse(number):
    sum = 0
    symbol = 1 if number > 0 else -1
    number = abs(number)
    while number != 0:
        sum = sum * 10 + number % 10
        number //= 10
    return sum * symbol



if __name__ == '__main__':
    a = int(input('please input an unsigned int 32:'))

    print(reverse(a))
