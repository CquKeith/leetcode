import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/4 19:29
 * 最小M段和问题
 * https://www.nowcoder.com/questionTerminal/491fc726f2a54234a963eb5c0d3dfc1a
 **/
public class MinMSegmentSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int m = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {

            array[i] = in.nextInt();
        }
        int res = schdule(m,array);
        //int res = schdule(3,new int[]{1,5,3,4,2});
        System.out.println(res);
    }

    /**
     * 动态规划解法
     *      牛客网通过率65%
     * @param m 节点个数
     * @param array
     * @return
     * d[i][j] = min (max (dp[k][j-1], dp[i][1]-dp[k][1]) );
     * d[i][j] = （（将i前k个分成j-1段，剩下的分成1段）的最大值）的最小值
     */
    private static int schdule(int m, int[] array){

        int n = array.length;

        //使用1～n dp[i][j]表示 前i个数 分成j段的最大和 中的最小值
        int [][]dp = new int[n+1][m+1];

        //前i个数 分成1段的最大和 的最小值
        for (int i = 1; i <= n; i++) {
            dp[i][1] = dp[i-1][1] + array[i-1];
        }
        //分成j段 j>1
        //
        int maxSum = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                //dp[i][j]
                int min = Integer.MAX_VALUE;

                for (int k = 0; k < i; k++) {
                    int temp = Math.max(dp[k][j-1],dp[i][1] - dp[k][1]);
                    min = Math.min(min,temp);
                }
                dp[i][j] = min;
            }
        }


        return dp[n][m];

    }

}
