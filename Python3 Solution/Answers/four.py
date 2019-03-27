# -*- coding: UTF-8 -*-
# @Time             : 2019-03-09 20:51
# @Author           : Keith
# @File             : four.py
# @Software         : PyCharm
# @About            :


nm = input().split(' ')
n = int(nm[0])
m = int(nm[1])
result = input()

series = result.split('0')
start = end = 0
c = ''
get = []
num = []
for serie in series:
    length = len(serie)
    for i in range(length):
        if serie[i] == ' ':
            continue
        if i == 0:
            c = serie[i]
            get.append(c)
            end += 1
        else:
            if serie[i] not in get:
                end += 1
                get.append(serie[i])
            else:
                if serie[i] == c:
                    start += 1
                    end += 1
                else:
                    end += 1
        if len(get) == m:
            num.append(end-start)
            break
min = min(num)
if min == 0:
    print(-1)
else:
    print(min)
