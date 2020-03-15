package CompanyInterviews2020.Pufa;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/10/21 21:05
 * 判断是否是素数
 * 对时间有极为严格的要求
 **/
public class PrimFastestSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        System.out.println(isPrim(a)?"YES":"NO");
    }

    /**
     * 除了2 3 外，所有的素数都是6x+1 6x+5(必要条件)
     * 因为6x，6x+2，6x+4 是2的倍数，6x+3也是3的倍数
     * 也就是说 不是6x+1或者6x+5的 一定不是素数
     * @param num
     * @return
     */
    private  static  boolean isPrim(long num){
        if (num <= 3){
            return num > 1;
        }

        // 不在6的两侧的，一定不是素数
        if (num % 6 != 1 && num % 6 != 5){
            return false;
        }
        //但在6倍数附近并不是一定就是素数，需判断
        int end = (int) Math.sqrt(num);
        for (int i = 5; i < end; i+=6) {
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }
}
