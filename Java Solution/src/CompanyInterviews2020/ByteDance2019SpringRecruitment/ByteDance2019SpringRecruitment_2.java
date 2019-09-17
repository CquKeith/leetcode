package CompanyInterviews2020.ByteDance2019SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/7/2019 9:23 PM
 * 字节跳动2019春招研发部分编程题汇总 第2题
 * 教训：
 *      不要将所有的方法写在static中，这样无法通过所有的实例
 *      写在新的类中，new新的对象的形式来做
 **/
public class ByteDance2019SpringRecruitment_2 {

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

//        System.out.println(new Solution().totalProgram(list, distance));
        System.out.println(totalProgram(list,distance));
    }

    /**
     * 滑动窗口的方法确定
     *
     * @param arrayList
     * @param maxDistance
     * @return
     */
    private static long solution(int[] arrayList, int maxDistance) {
        int result = 0;
        int mod = 99997867;
//        if (arrayList.length < 3) {
//            return -1;
//        }

        //以left为基准，滑动着找符合条件的最大的right

        for (int left = 0,right = 1; left <= arrayList.length - 1; left++) {
            while (right < arrayList.length-1 && arrayList[right + 1] - arrayList[left] <= maxDistance) {
                right++;
            }
            if (right - left > 1) {
                result += calcCn2(right - left);
            }
        }

        //以right为基准，滑动着找符合条件的最小的left
//        for (int right = 2,left = 0; right < arrayList.length; right++) {
//            while (arrayList[right] - arrayList[left] > maxDistance) {
//                left++;
//            }
////            if (right - left > 1){
//                result += calcCn2(right - left);
////            }
//
//
//        }
//        for (int right = 2, left = 0; right < arrayList.length; right++) {
//            while ((arrayList[right] - arrayList[left]) > maxDistance) {
//                left++;
//            }
//            result += calcCn2(right - left);
//        }
//        return result % mod;

//        for (int right = 0, left = 0; right < arrayList.length; right++) {
//            while (right >= 2 && (arrayList[right] - arrayList[left]) > maxDistance) {
//                left++;
//            }
//            if (right - left >= 2){
//
//                result += calcCn2(right - left);
//            }
//        }
        return result % mod;


    }

    /**
     * 计算Cn2
     * 比如left在0，right在4，则0肯定选中，载重1 2 3 4 中选择两个
     * 注意：
     * 如果从0~4中通过C53来选择，可能选123，但是1~4中通过C43也可能会选中123，这样就重复了
     * 所以不能通过Cn3来选
     *
     * @param n
     */
    private static long calcCn2(int n) {
        return n * (n - 1) / 2;
    }




    static long totalProgram(int[] arrayList, int maxDistance) {
        int result = 0;
        int mod = 99997867;
        for (int left = 0; left <= arrayList.length - 1; left++) {
            int right = left + 1;
            while (right < arrayList.length-1 && arrayList[right + 1] - arrayList[left] <= maxDistance) {
                right++;
            }
            if (right - left > 1) {
                result += calcCn2(right - left);
            }
        }
        return result % mod;

    }



}


class Solution {
    private final int mod = 99997867;
    private long result = 0;

    public long totalProgram(int[] arrayList, int maxDistance) {

        for (int left = 0; left <= arrayList.length - 1; left++) {
            int right = left + 1;
            while (right < arrayList.length-1 && arrayList[right + 1] - arrayList[left] <= maxDistance) {
                right++;
            }
            if (right - left > 1) {
                result += computeCn(right - left);
            }
        }
        return result % mod;
    }

    private long computeCn(long n) {
        return n * (n - 1) / 2;
    }
}
