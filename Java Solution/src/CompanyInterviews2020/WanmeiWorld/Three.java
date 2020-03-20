package CompanyInterviews2020.WanmeiWorld;

import java.util.Scanner;

/**
 * @author chenmengliang
 * 背包问题
 **/
public class Three {
    public static void main(String[] args) {
        Three three = new Three();
        Scanner scanner = new Scanner(System.in);
        // 装备数量
        int num = scanner.nextInt();
        int maxCapacity = scanner.nextInt();
        int[] weight = new int[num];
        int[] value = new int[num];
        for (int i = 0; i < num; i++) {
            weight[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            value[i] = scanner.nextInt();
        }
        System.out.println(three.calcMaxValue(weight, value, maxCapacity,num));

    }

    /**
     *
     * @param weight 重量
     * @param value 价值
     * @param maxCapacity 背包重量的容量
     * @param num 装备种类
     * @return
     */
    public long calcMaxValue(int[] weight, int[] value, int maxCapacity, int num) {

        if (num == 0) {
            return 0L;
        }
        if (value[num - 1] > maxCapacity) {
            return calcMaxValue(weight, value, maxCapacity, num - 1);
        } else {
            return Math.max(value[num - 1] + calcMaxValue(weight, value, maxCapacity - value[num - 1], num - 1), calcMaxValue(weight, value, maxCapacity, num - 1));
        }

        //int[][] dp = new int[num + 1][maxCapacity + 1];
        //
        //for (int i = 1; i <= num; i++) {
        //    for (int j = 1; j <= maxCapacity; j++) {
        //        if (weight[i - 1] > j) {
        //            dp[i][j] = dp[i - 1][j];
        //        } else {
        //            dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]]) + value[i - 1];
        //        }
        //    }
        //}
        //return dp[num][maxCapacity];

        //int[] dp = new int[num + 1];
        //for (int i = 1; i <= num; i++) {
        //    for (int j = num; j >= weight[i-1]; j--) {
        //        dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
        //    }
        //}
        //
        //return dp[num];
    }
}
