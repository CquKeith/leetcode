# -*- coding: UTF-8 -*-
# @Time             : 2019-03-09 20:36
# @Author           : Keith
# @File             : two.py
# @Software         : PyCharm
# @About            :


q = int(input('input q:'))

arr = []

for i in range(q):
    lr = input('input l r:')
    left = int(lr[0])
    right = int(lr[1])

    count = right - left + 1

    # 偶数个
    if count % 2 == 0:
        dui = count / 2
        w = 1 if left%2==1 else 0
        print(w*dui)
        continue
    # 奇数个
    else:
