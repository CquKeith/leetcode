package CompanyInterviews2020.Pinduoduo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/25 15:08
 **/
public class Four {
    private static final long MOD = 1000000007;

    //记录3 的 n次方 % MOD 之后的值
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {

        memo.put(1L, 3L);

        Scanner scanner = new Scanner(System.in);
        int examplesNum = scanner.nextInt();
        for (int i = 0; i < examplesNum; i++) {
            //每一个测试用例
            //数组个数
            long n = scanner.nextLong();
            int arrangementedWeekendNum = scanner.nextInt();

            long[] weekend = new long[(int) n + 1];
            int[] arranted = new int[arrangementedWeekendNum];

            if (arrangementedWeekendNum != 0) {
                for (int j = 0; j < arrangementedWeekendNum; j++) {
                    arranted[j] = scanner.nextInt();
                }
                for (int j = 0; j < arrangementedWeekendNum; j++) {
                    weekend[arranted[j]] = scanner.nextInt();
                }
            }

            System.out.println(solution(weekend, arrangementedWeekendNum));

            weekend = null;

        }

    }

    /**
     * @param weekends     有几个周末
     * @param arrantedDays 有几个已经有了固定的安排了
     * @return
     */
    private static long solution(long[] weekends, int arrantedDays) {

        //System.out.println("---------------"+weekends + " "+arrantedDays);
        if (arrantedDays == 0) {
            return 4 * calc3power(weekends.length - 1 - 1) % MOD;
        }

        long ans = 1L;

        for (int i = 1; i < weekends.length; i++) {
            if (weekends[i] != 0) {
                continue;
            }

            if (weekends[i - 1] != 0) {
                if (i + 1 < weekends.length && weekends[i + 1] != 0) {
                    if (weekends[i-1] == weekends[i+1]){
                        ans  = ans * 3 % MOD;
                    }else {
                        ans = ans * 2 % MOD;
                    }
                }

            } else {

            }

        }


        return ans;
    }

    private static long calc3power(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long res = 3 * calc3power(n - 1) % MOD;
        memo.put(n, res);

        return res;

    }

}
