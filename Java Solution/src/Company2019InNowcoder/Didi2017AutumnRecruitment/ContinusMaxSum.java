package Company2019InNowcoder.Didi2017AutumnRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/26/2019 12:04
 **/
public class ContinusMaxSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(new ContinusMaxSum().maxSumLinear(array));
    }

    /**
     * 暴力方法找出所有连续的子数组，进而找出最大的和
     * 只能通过90% 运行超时:您的程序未能在规定时间内运行结束，请检查是否循环有错或算法复杂度过大。
     *
     * @param array
     * @return
     */
    private int maxSum(int[] array) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = array[i];
            max = Math.max(max, sum);

            for (int j = i + 1; j < array.length; j++) {
                sum += array[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    /**
     * 动态规划的解法
     * sum 保存连续的几个数 最大的和 如果遇到加上array[i]发现比array[i]还小，说明sum之前是负数，就从array[i]开始重新计算sum
     * 每次加完 更新ans，即当前的最大值
     *
     * @param array
     * @return
     */
    private int maxSumDPSolution(int[] array) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int item : array) {
            //判断要不要从当前重新算sum
            sum = Math.max(sum + item, item);
            ans = Math.max(sum, ans);
        }

        return ans;
    }

    /**
     * 类似动态规划的思想
     * 当sum<0时，再加上下一项，肯定没有贡献的，也就是说肯定比下一项本身还小
     * 所以sum<0时，就直接清零，直接从下一项开始计算
     *
     * @param array
     * @return
     */
    private int maxSumLinear(int[] array) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int item : array) {
            sum += item;
            ans = sum > ans ? sum : ans;
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}
