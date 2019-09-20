package CompanyInterviews2020.Webank;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-19 16:27
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(solution(n));

    }
    private static long solution(int n){
        if (n <= 1){
            return 1;
        }
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
            //找当前ans的第一个不为0的
            while (ans % 10 == 0){
                ans /= 10;
            }
            ans %= 10;
        }
        return (int) (ans % 10);
    }

}
