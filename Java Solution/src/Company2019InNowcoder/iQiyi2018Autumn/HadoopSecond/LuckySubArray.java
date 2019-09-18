package Company2019InNowcoder.iQiyi2018Autumn.HadoopSecond;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/18 11:26
 * 爱奇艺2018秋季校招hadoop工程师（第二场）
 * [编程题]幸运子序列
 **/
public class LuckySubArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        //2<= n <= 100000
        int n = scanner.nextInt();
        int[] arr = new int[n];
        //1 ≤ V[i] ≤ 10^8
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(new LuckySubArray().findLuckySubArrayForce2(arr));
    }

    private int findLuckySubArrayForce2(int[] array) {

        int res = 0;
        int max ,secondMax;

        for (int i = 0; i < array.length; i++) {
            //i作为最大的
            max = array[i];
            secondMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > max){
                    break;
                }
                if (array[j] > secondMax){
                    secondMax = array[j];
                    res = Math.max(res,max ^ secondMax);
                    //System.out.println("max:" + max + "  secondMax:" + secondMax + "  res:" + res);
                }
            }

            // i作为第二大的
            //当前比i要大的数
            int numOfBiggerThanCur = 0;
            secondMax = array[i];
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > secondMax){
                    max = array[j];
                    if (++numOfBiggerThanCur > 1){
                        break;
                    }
                    res = Math.max(res,max ^ secondMax);
                    //System.out.println("max:" + max + "  secondMax:" + secondMax + "  res:" + res);
                }
            }
        }
        return res;


    }

    ///**
    // * 先从大到小排序 然后每次选中相邻的两个
    // * !!!!!!!!!!!!!!!!!!!!!!!!!!!排好序之后 不能确定相邻的两个数 在原序列中就是最大和次大的
    // * @param array
    // * @return
    // */
    //private int findLuckySubArray(int[] array) {
    //    Arrays.sort(array);
    //    System.out.println(Arrays.toString(array));
    //    int ans = 0;
    //    for (int i = array.length-1; i >= 1 ; i--) {
    //        int max = array[i];
    //        int secondMax = array[i-1];
    //        int temp;
    //        if (( temp = max ^ secondMax) > ans){
    //            ans = Math.max(ans,temp);
    //        }
    //        System.out.println("max:"+max+" secondMax:"+secondMax+" ans: "+ans);
    //    }
    //    return ans;
    //}

    /**
     * 牛牛得到一个长度为n的整数序列V,
     * 牛牛定义一段连续子序列的幸运值为这段子序列中最大值和次大值的异或值(次大值是严格的次大)。
     * 牛牛现在需要求出序列V的所有连续子序列中幸运值最大是多少。请你帮帮牛牛吧。
     *
     * @param array
     * @return 暴力解法 完成30%
     */
    private int findLuckySubArrayForce(int[] array) {
        int ans = 0;
        for (int i = 0; i < array.length - 1; i++) {

            int max = array[i], secondMax = array[i];

            for (int j = 1; j < array.length; j++) {

                if (array[j] <= secondMax) {
                    continue;
                }

                max = Math.max(max, array[j]);

                if (array[j] < max && array[j] > secondMax) {
                    secondMax = array[j];
                }

                ans = Math.max(ans, max ^ secondMax);
                System.out.println("max:" + max + "  secondMax:" + secondMax + "  ans:" + ans);
            }
        }
        return ans;
    }
}
