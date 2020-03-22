package CompanyInterviews2020.Kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenmengliang
 *  * 输出逆序对个数是1的
 *  * O(n)
 **/
public class Two {
    public static void main(String[] args) {

        Two two = new Two();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Long> nums = new ArrayList<>();
        String[] s = line.split(" ");
        for (String value : s) {
            nums.add(Long.parseLong((value)));
        }

        two.printReservePairIsOne(nums);

        // 4 7
        //two.printReservePairIsOne(new int[]{1, 22, 22, 33, 22, 12, 45, 44, 5});
        // -1
        //two.printReservePairIsOne(new int[]{1,22,54,123});
    }

    /**
     * 输出下标：
     *  A[i] 满足A[k]>A[i] 0<=k<i，的个数只有一个的数组下标
     *  保存历史最大和次大
     *  遍历，A[i]<max && A[i]>=second
     *  63.64%
     * @param nums
     */
    public void printReservePairIsOne(List<Long> nums) {
        if (nums.size() <= 1) {
            return;
        }

        // 历史最大
        long max = nums.get(0);

        // 历史第二大
        long second = Long.MIN_VALUE;

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.size(); i++) {
            long num = nums.get(i);
            if (num >= second && num < max) {
                list.add(i);
            }
            // 更新最大和第二大
            if (num > max) {
                second = max;
                max = num;
            }
            if (num > second) {
                second = num;
            }
        }
        if (list.isEmpty()) {
            System.out.print("-1");
        } else {
            list.forEach(a-> System.out.print(a+" "));
        }
    }
}
