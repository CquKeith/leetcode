package CompanyInterviews2020.Tencent2019AutumnRecruitment.Three;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-20 20:38
 * 10% TLE
 **/
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examples = scanner.nextInt();
        for (int i = 0; i < examples; i++) {

            int n = scanner.nextInt();
            int []nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            solution(nums);

        }
    }

    /**
     * 先排序
     * left right记录当前两对的和
     * 遇到两个数 大的加在小的里面 小的加在大的上面
     * @param nums
     */
    private static void solution(int[] nums){

        if (nums.length == 2){
            System.out.println(Math.min(nums[0],nums[1]) + " "+Math.max(nums[0],nums[1]));
        }

        Arrays.sort(nums);

        int left = nums[0];
        int right = nums[1];

        for (int i = 2; i < nums.length-1; i+=2) {
            int min = Math.min(nums[i],nums[i+1]);
            int max = Math.max(nums[i],nums[i+1]);
            if (left > right){
                left += min;
                right += max;
            }else {
                left += max;
                right += min;
            }
        }
        //奇数个 说明最后一个还没有加
        if (nums.length % 2 == 1){
            if (left > right){
                right += nums[nums.length-1];
            }else {
                left += nums[nums.length-1];
            }
        }

        System.out.println(Math.min(left,right) + " "+Math.max(left,right));
    }
}
