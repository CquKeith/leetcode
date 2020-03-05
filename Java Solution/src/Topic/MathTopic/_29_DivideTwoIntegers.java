package Topic.MathTopic;

/**
 * @author chenmengliang
 * @date 2020/3/4 18:17
 * 29. 两数相除
 * https://leetcode-cn.com/problems/divide-two-integers/
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。本题中，如果除法结果溢出，则返回 2^31 − 1。
 **/
public class _29_DivideTwoIntegers {
    public static void main(String[] args) {

        _29_DivideTwoIntegers divideTwoIntegers = new _29_DivideTwoIntegers();
        //System.out.println(divideTwoIntegers.divide(10, 3));
        //System.out.println(divideTwoIntegers.divide(7, -3));
        //System.out.println(divideTwoIntegers.divide(-2147483648, 2));
        System.out.println(divideTwoIntegers.divide(1100540749,- 1090366779));

    }

    /**
     * @param dividend 除数
     * @param divisor  被除数
     * @return 商
     * 注意 Integer.MIN_VALUE取反会正溢出，数值上看起MIN_VALUE取反之后还是MIN_VALUE
     */
    public int divide(int dividend, int divisor) {

        // 检查边界、特殊情况
        if (divisor == 1) return dividend;

        // 处理正溢出
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        }

        // 同号为正
        boolean negative = (dividend > 0) ^ (divisor > 0);
        int ans = 0;

        // 全部转化为负数，因为转化成正数的话，如果是INT_MIN / 2，INT_MIN无法转成对应的相反数，会溢出
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        // 做加法
        // 如果步长一直是divisor，太慢了 可能会超时
        int currentDivisor = divisor;
        int currentLen = 1;
        while (dividend <= currentDivisor) {
            dividend -= currentDivisor;
            ans += currentLen;

            // 将divisor加倍，看是否还可以
            // 如果可以，那么就肯定步长。否则恢复到最开始
            // 类似TCP拥塞控制：慢启动，每次翻倍，一旦不行，立马恢复最小，避免错过
            // 但是currentDivisor翻倍的时候要小心，避免翻倍之后溢出
            // currentDivisor如果小于INT_MIN的一半，那么currentDivisor翻倍之后一定"小于"INT_MIN，就溢出了
            if (currentDivisor  < Integer.MIN_VALUE >> 1){
                continue;
            }

            currentDivisor += currentDivisor;
            currentLen <<= 1;
            if (dividend > currentDivisor) {
                currentDivisor = divisor;
                currentLen = 1;
            }
        }


        return negative ? -ans : ans;

    }
}
