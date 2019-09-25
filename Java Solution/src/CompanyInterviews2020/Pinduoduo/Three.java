package CompanyInterviews2020.Pinduoduo;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/25 15:08
 * a 不超过n个 b不超过m个
 * 求字典序第k小的单词
 * 如n = 2 b = 1 k = 4; 最终是ab
 * a
 * aa
 * aab
 * ab
 * aba
 * b
 * ba
 * baa
 * 类似
 * https://www.nowcoder.com/questionTerminal/12b1b8ef17e1441f86f322b250bff4c0
 *
 **/
public class Three {
    //a 的数量 (0,n] 个
    private static int n;

    //b 的数量 (0,m] 个
    private static int m;

    //求字典序第k小的
    private static long k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        m = scanner.nextInt();
        k = scanner.nextLong();

        solution();
    }

    /**
     * 当前位置 如果选a 后面有多少种可能，如果大于等于k，则确定为a
     * 否则确定为b
     */
    private static void solution(){

        StringBuilder stringBuilder = new StringBuilder();

        //当前是第index种 字典序的排序
        int index = 0;

        //判断当前第i位是a还是b
        int i = 1;
        int cnt = m + n;
        while (i < cnt){

            //如果当前位置是a，看后面有多少种可能


        }



        System.out.println(stringBuilder.toString());
    }

}
