// PreviousQuestion.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//
/*
题目:
1. 从命令行输入若干个正整数(大于等于2个)，得到一个集合N。
2. 从N中任意取出两个数并求和，得到的值构成集合A。
3. 从N中任意取出两个数，并求差的绝对值，得到的值构成集合B。
4. 从集合A和集合B当中，任意取出两个数，其差的绝对值，又构成集合D
D的最小元素是d1, D的最大元素是d2, D的元素个数是s
请输出d1 + d2 + s

题目要求

编译器版本 : gcc 4.8.4
	请使用标准输入输出(stdin，stdout) ；请把所有程序写在一个文件里，勿使用已禁用图形、文件、网络、系统相关的头文件和操作，如sys / stat.h, unistd.h, curl / curl.h, process.h
	时间限制 : 3S(C / C++以外的语言为: 5 S) 内存限制 : 128M(C / C++以外的语言为: 640 M)
	输入 :
	n //这是输入整数的个数 x1 //第一个整数 x2 //第二个整数 ... xn //第n个整数
	输出 :
m //一个整数
输入范例 :
5
101
102
103
104
105
输出范例:
417

题目中的代码 :
*/


#include "pch.h"
#include <iostream>
#include <vector>
#include <numeric>
#include <limits>
#include <set>
#include <algorithm>
using namespace std;
// 请完成下面这个函数，实现题目要求的功能
// 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
int result(const vector <int>& inputs) {
	
	set<int> s, A, B, D;

	for (auto i : inputs)
		s.insert(i);

	for (auto i = s.begin(); i != (s.end()); i++)
	{
		for (auto j = next(i); j != s.end(); j++)
		{
			A.insert(*i + *j);

			int tmp = *i - *j;
			tmp = tmp > 0 ? tmp : -tmp;
			B.insert(tmp);
		}
	}

	for (auto i = A.begin(); i != prev(A.end()); i++)
	{
		for (auto j = B.begin(); j != B.end(); j++)
		{
			D.insert((abs)(*i - *j));
		}
	}

	vector<int> ivec(D.begin(), D.end());

	sort(ivec.begin(), ivec.end());

	return ivec[0] + ivec[ivec.size() - 1] + ivec.size();
	

}

int main() {
	int size = 0;
	cin >> size;
	cin.ignore(numeric_limits<std::streamsize>::max(), '\n');
	vector<int> points;
	for (size_t i = 0; i < size; ++i) {
		int item;
		cin >> item;
		cin.ignore(numeric_limits<std::streamsize>::max(), '\n');
		points.push_back(item);
		
	}
	int res = result(points);
	cout << res << endl;
	return 0;
	
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门提示: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
