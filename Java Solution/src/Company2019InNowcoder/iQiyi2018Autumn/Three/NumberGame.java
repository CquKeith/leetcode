package Company2019InNowcoder.iQiyi2018Autumn.Three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/17 21:33
 * 爱奇艺2018秋季校招java工程师（第三场）
 * 数字游戏
 **/
public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,renewNum(scanner.nextInt()));
        }

        System.out.println(max);

    }

    /**
     * 一个数字将其数位按照非递减顺序排列,得到新的数
     * 如9638 排序 改成3689
     * @param num
     * @return
     */
    private static int renewNum(int num){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        while (num!=0){
            list.add(num%10);
            num /= 10;
        }
        list.sort(null);
        for (int item :
                list) {
            sum = sum*10 + item;
        }


        return sum;

    }

}
