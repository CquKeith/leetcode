package Tencent2018SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/16/2019 20:00
 **/
public class One {

    private void solution() {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int m = scanner.nextInt();
        long sum = 0L;
        //当前的符号 -1 +1代表- +
        int currentSymbol = -1;
        for (int i = 1, k = 0; i <= n; i++) {
            //刚开始为- ， 没隔m个反转符号
            if (++k > m) {
                k = 1;
                currentSymbol *= -1;
            }
            sum += currentSymbol * i;
        }

        System.out.println(sum);
    }


    public static void main(String args[]) {
        new One().solution();
    }
}
