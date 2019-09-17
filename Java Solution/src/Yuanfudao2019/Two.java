package Yuanfudao2019;

import java.util.Scanner;

/**
 * @author Keith
 **/
public class Two {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long limitSum = scanner.nextLong();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }

        scanner.close();

        //算法部分

        System.out.println(longestNoAlamCourseNum(nums,limitSum));
    }

    /**
     *  f(n) 记录当前不超过 limit的和
     *  f(0) = A0;
     *  f(1) = f(0) + A1 <= limit ? f(0) + A1 : f(0)
     * @param nums
     * @param limit
     * @return
     */
    private static int longestNoAlamCourseNum(long[] nums, long limit){
        if (nums.length == 0){
            return 0;
        }

        int start = 0,end = 0;
        long sum = 0L;
        int ans = 0;
        while (end < nums.length){

            sum += nums[end];
            if (sum > limit){
                while (sum > limit){
                    sum -= nums[start];
                    start++;
                    if (start == end && sum > limit){
                        sum = 0;
                        start += 1;
                        break;
                    }
                }

            }
            ans = Math.max(ans,end - start + 1);
            end++;
        }

        //long [] dp = new long[nums.length];
        //dp[0] = nums[0];
        //int ans = dp[0] <= limit ? 1 : 0;
        //for (int i = 1; i < nums.length; i++) {
        //    long sum = dp[i-1] + nums[i];
        //    if (sum <= limit){
        //        dp[i] = sum;
        //        ans++;
        //    }
        //}
        return ans;
    }
}
