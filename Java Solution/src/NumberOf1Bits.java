import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-16 9:16
 * [191. 位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)
 **/
public class NumberOf1Bits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //int a = Integer.parseInt(scanner.next());
        System.out.println(new NumberOf1Bits().hammingWeight(-3));

    }

    /**
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        //扫描32个bit
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    /**
     * 方法一：转换成字符串处理
     *  7ms,击败5.73%
     * @param n
     * @return
     */
    public int hammingWeightStringSolution(int n) {
        String temp = Integer.toBinaryString(n);
        System.out.println(temp);
        int count = 0;
        for (Character item :
                temp.toCharArray()) {
            if ('1' == item) {
                count++;
            }

        }

        return count;
    }
}
