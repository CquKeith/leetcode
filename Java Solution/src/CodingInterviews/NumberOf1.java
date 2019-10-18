package CodingInterviews;

/**
 * @author chenmengliang
 * @date 2019/10/18 14:14
 **/
public class NumberOf1 {
    public static void main(String[] args) {

        NumberOf1 numberOf1 = new NumberOf1();
        int n = -1;
        System.out.println(Integer.toBinaryString(n));

        System.out.println(numberOf1.numberOf1(n));
    }

    /**
     *
     * @param n
     * @return n的二进制表示中1的个数。其中负数用补码表示。
     */
    public int numberOf1(int n){
        int count = 0;

        while (n != 0){
            if ((n & 1) == 1){
                count++;
            }
            n >>>= 1;
        }

        return count;
    }
}
