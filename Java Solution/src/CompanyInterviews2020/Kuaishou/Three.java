package CompanyInterviews2020.Kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenmengliang
 * 100%
 **/
public class Three {
    public static void main(String[] args) {
        Three three = new Three();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] nums = line.split(",");

        // 得到靓号的index int[]中 第0个元素是index，第1个元素是价值，第2个是1：豹子，0：顺子
        List<int[]> beautifulNumIndex = three.getBeautifulNumberIndex(nums);

        if (beautifulNumIndex.isEmpty()) {
            System.out.println("null");
            return;
        }

        // 按照价值排序
        beautifulNumIndex.sort((num1,num2)->{
            // 总价值不等，按照总价值排序
            if (num1[1] != num2[1]) {
                return num2[1] - num1[1];
            }
            // 总价值相等，按照豹子>顺子的顺序排序
            else if (num1[2] != num2[2]) {
                return num2[2] - num1[2];
            }
            // 价值完全相等，按照index排序
            else {
                return num1[0] - num2[0];
            }
        });
        int i = 0;
        for (; i < beautifulNumIndex.size() - 1; i++) {
            System.out.print(nums[beautifulNumIndex.get(i)[0]]+",");
        }
        System.out.println(nums[beautifulNumIndex.get(i)[0]]);

    }

    /**
     * 获取靓号的index
     * @param nums
     * @return
     */
    public List<int[]> getBeautifulNumberIndex(String[] nums) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            String num = nums[i];
            int[] temp = new int[3];
            temp[0] = i;

            StringBuilder stringBuilder = new StringBuilder(num.substring(3));

            // 最长连续上升子序列的长度
            int shunZiValue = longestOfLIS(stringBuilder.toString());
            shunZiValue = Math.max(shunZiValue, longestOfLIS(stringBuilder.reverse().toString()));

            int baoZiValue = longestOfRepeat(stringBuilder.toString());

            if (shunZiValue < 3 && baoZiValue < 3) {
                continue;
            }


            if (shunZiValue > baoZiValue) {
                temp[1] = shunZiValue;
            } else {
                temp[1] = baoZiValue;
                temp[2] = 1;
            }
            list.add(temp);

        }
        return list;
    }

    /**
     * 最多连续重复的数字的值
     * @param num
     * @return 最长连续重复子序列的长度
     */
    private int longestOfRepeat(String num) {

        int[] dp = new int[num.length()];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) == num.charAt(i - 1)) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 最长连续上升子序列的长度
     * @param num
     * @return
     */
    private int longestOfLIS(String num) {
        int[] dp = new int[num.length()];

        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) - num.charAt(i - 1)  == 1) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
