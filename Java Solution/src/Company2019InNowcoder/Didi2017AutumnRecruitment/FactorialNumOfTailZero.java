package Company2019InNowcoder.Didi2017AutumnRecruitment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/30/2019 11:03
 * 求n！的末尾有几个0
 **/
public class FactorialNumOfTailZero {

    private Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        new FactorialNumOfTailZero().solutionEasy(n);
    }

    /**
     * 比较巧妙的办法
     * n! = n*(n-1)*(n-2)*...*2*1
     * 要想结果的末尾有0，也就是偶数*5，那么上面等式右边必须有足够的5（有足够的5，那么肯定有足够的2了）
     *
     * @param n
     */
    private void solutionEasy(int n) {
        int ans = 0;
        int num2 = 0,num5 = 0;
        while (n != 1) {
            //计算n 能分解出来多少个5
            int temp = n;
            while (temp % 5 == 0) {
                temp /= 5;
                num5++;
            }
            //计算n能分解出多少个2
            temp = n;
            while (temp % 2== 0){
                temp /= 2;
                num2++;
            }
            n--;
        }
        System.out.println("num2:"+num2+" num5:"+num5);
        System.out.println(Math.min(num2,num5));
    }

    /**
     * 求n！ 然后求结果的末尾有几个0
     *
     * @param n !!!!!!!!!!!!!!!!!!!!!!通过率60%  n=999时，输出了0，正确答案是 246
     */
    private void solutinDP(int n) {
        long fac = factorial(n);
        System.out.println(numberOfZero(fac));
    }

    private long factorial(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0 || n == 1) {
            map.put(n, 1L);
            return 1L;
        }
        long ans = n * factorial(n - 1);
        map.put(n, ans);
        return ans;
    }

    /**
     * @param number
     * @return number后面有几个0
     */
    private int numberOfZero(long number) {
        int ans = 0;

        while (number != 0 && number % 10 == 0) {
            ans++;
            number /= 10;
        }

        return ans;
    }
}
