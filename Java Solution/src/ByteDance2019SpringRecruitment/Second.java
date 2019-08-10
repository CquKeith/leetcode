package ByteDance2019SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/9/2019 3:39 PM
 * 2019 字节跳动春招第二题
 **/
public class Second {
    public static void main(String args[]) {


        int num, distance;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        distance = scanner.nextInt();

        int[] list = new int[num];

        for (int i = 0; i < num; i++) {
            list[i] = scanner.nextInt();
        }

        scanner.close();

        System.out.println(new Solution2().totalProgram(list, distance));
    }
}

class Solution2 {
    private final int mod = 99997867;
    private long result = 0;

    public long totalProgram(int[] arrayList, int maxDistance) {

        for (int left = 0, right = 0; left <= arrayList.length - 1; left++) {
            while (right < arrayList.length - 1 && arrayList[right + 1] - arrayList[left] <= maxDistance) {
                right++;
            }
            //right - left > 1 才能保证[left,right]至少有3个数
            // 本轮有满足条件的，才计算
            if (right - left > 1) {
                result += calcCn2(right - left);
            }

        }
        return result % mod;

    }

    private long calcCn2(long n) {
        return n * (n - 1) / 2;
    }

}