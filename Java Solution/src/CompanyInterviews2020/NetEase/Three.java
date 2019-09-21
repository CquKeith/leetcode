package CompanyInterviews2020.NetEase;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-21 15:32
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examplesNum = scanner.nextInt();
        for (int i = 0; i < examplesNum; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            System.out.println(longestPerfectSequence(nums));
        }
    }

    /**
     * dp 存储每个到当前的完美数的和
     * @param nums
     * @return
     */
    private static int longestPerfectSequence(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }

        int startIndex = 0;
        int ans = 1;

        long [] dp = new long[nums.length + 1];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= dp[i-1]){
                dp[i] = dp[i-1] = nums[i];
            }else {
                startIndex = i;
                dp[i] = nums[i];
            }

            ans = Math.max(ans,i - startIndex + 1);
        }
        return ans;
    }
}
