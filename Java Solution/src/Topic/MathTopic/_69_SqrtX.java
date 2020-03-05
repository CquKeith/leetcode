package Topic.MathTopic;

/**
 * @author chenmengliang
 * @date 2020/3/5 21:22
 * 69. x 的平方根
 * https://leetcode-cn.com/problems/sqrtx/
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 **/
public class _69_SqrtX {
    public static void main(String[] args) {
        _69_SqrtX sqrtX = new _69_SqrtX();
        System.out.println(sqrtX.mySqrt(2));
        System.out.println(sqrtX.mySqrt(4));
        System.out.println(sqrtX.mySqrt(8));
        System.out.println(sqrtX.mySqrt(2147395600));
    }

    /**
     *
     * @param x 非负
     * @return x 的开方，结果向下取整
     */
    public int mySqrt(int x) {
        // 结果肯定是1的
        if (x <= 1) {
            return x;
        }
        // 结果肯定大于1的,x的开方应该在[1,x/2]
        // 在[1,x/2]区间内 二分查找
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 注意这里要将第一个mid先强制转化成long，mid*mid的结果才能是没有溢出的long
            // 否则如果mid很大，mid*mid本应特别大，但是由于溢出，导致mid*mid显示的值是比x小的
            long mid2 = (long) mid * mid;
            if (mid2 == x) {
                return mid;
            } else if (mid2 < x) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }
        // 这里应该返回的是right 而不是mid
        // 因为如果x == 2或者3，结果应该是1：left=2，right=1，while循环不会执行，直接跳到这里返回
        return right;
    }
}
