package CompanyInterviews2020.Webank;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-19 16:34
 * AC
 **/
public class Two {
    private static int helper = (int) (Math.pow(10,6)+3);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(calcJie(n));

        scanner.close();
    }
    private static long calcJie(int n){
        if (n <= 1){
            return 1;
        }
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            res %= helper;
        }
        return res;
    }
}
