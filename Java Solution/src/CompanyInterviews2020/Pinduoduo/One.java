package CompanyInterviews2020.Pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/25 15:08
 * AC
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int m = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(calcMinAcc(nums,m));
    }

    /**
     *
     * @param nums
     * @param m 进行m轮
     * @return
     */
    public static long calcMinAcc(int[] nums,int m){
        long res = 0;

        Arrays.sort(nums);

        int cnt = m << 1;
        for (int i = 0; i < m; i++) {
            res += nums[i] * nums[cnt - 1 - i];
        }


        return res;
    }
}
