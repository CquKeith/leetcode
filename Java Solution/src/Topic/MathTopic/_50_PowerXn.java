package Topic.MathTopic;

/**
 * @author chenmengliang
 * @date 2020/3/5 16:13
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/22 = 1/4 = 0.25
 **/
public class _50_PowerXn {
    public static void main(String[] args) {

        _50_PowerXn powerXn = new _50_PowerXn();
        System.out.println(powerXn.myPow(2.00000, 10));
        System.out.println(powerXn.myPow(2.10000, 3));
        System.out.println(powerXn.myPow(2.00000, -2));
        System.out.println(powerXn.myPow(2.00000,2147483647));
    }

    /**
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        double ans = 1.0;
        boolean needReciprocal = n < 0;
        // 每次把n减半
        while (n != 0) {

            // n是奇数，则结果会少乘，损失了那个少乘的数恰好是上次的x值
            // 最终n为1时，乘上之前累计的结果，也就是x
            if (n % 2 != 0) {
                ans *= x;
            }

            // 对幂加倍，加倍的次数是n减半的次数
            x *= x;
            // n砍半
            n /= 2;
        }

        return needReciprocal ? 1 / ans : ans;
    }

    /**
     * 如果已知x^(1/2n),求x^n只需要将前面平方即可，不需要继续乘1/2n次了
     * @param x
     * @param n
     * @return
     */
    public double myPowStackOverFlow(double x, int n) {

        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -n;
        }

        return fastHalfPow(x, N);

    }

    /**
     * N 如果是Integer.MAX，会stackOverFlow
     * @param x
     * @param N
     * @return
     */
    @Deprecated
    private double fastHalfPow(double x, long N) {
        // 0次幂 、底数是1
        if (N == 0 || x == 1.0) {
            return 1;
        }
        // 底数是-1
        if (x == -1.0) {
            return N % 2 == 0 ? 1.0 : -1.0;
        }
        double half = fastHalfPow(x, N >> 1);
        // 看n >> 1有没有牺牲精度，奇数会使结果少乘一个x
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 废弃：超时
     * @param x double类型底数
     * @param n int 指数
     * @return x^n
     */
    @Deprecated
    public double myPowWrong(double x, int n) {
        // 0次幂 、底数是1
        if (n == 0 || x == 1.0) {
            return 1;
        }
        // 底数是-1
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }

        // 负次幂按照正次幂来算，最后求倒数即可
        boolean needReciprocal = n < 0;
        n = Math.abs(n);
        double ans = 1.0;
        while (n-- > 0) {
            ans *= x;
        }
        // 修正，看是否需要取倒数
        ans = needReciprocal?1/ans:ans;
        return ans;
    }
}
