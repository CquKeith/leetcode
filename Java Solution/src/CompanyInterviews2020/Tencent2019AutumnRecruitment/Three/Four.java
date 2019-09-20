package CompanyInterviews2020.Tencent2019AutumnRecruitment.Three;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-20 21:09
 * AC
 **/
public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        findMin(nums,k);
    }

    /**
     *
     * @param nums
     * @return
     */
    private static void findMin(int[] nums,int k){

        int epsiodSum = nums[0];
        System.out.println(nums[0]);
        int times = k > nums.length ? nums.length : k;
        int cnt = 1;

        for (int i = 1; i < times && i < nums.length;i++) {
            if (nums[i] == epsiodSum){
                times++;
                continue;
            }
            System.out.println(nums[i] - epsiodSum);
            epsiodSum += nums[i] - epsiodSum;
            cnt++;
        }
        while (cnt++ < k){
            System.out.println(0);
        }


    }
}
