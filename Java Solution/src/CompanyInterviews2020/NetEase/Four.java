package CompanyInterviews2020.NetEase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-21 16:12
 **/
public class Four {
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(ans);
    }

    private static int reversePairDistanceSumForce(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    ans += Math.abs(nums[i] - nums[j]);
                }
            }
        }

        return ans;
    }
}
