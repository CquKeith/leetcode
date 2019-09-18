package CodingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2019/9/17 23:08
 * https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 **/
public class Fibonacci {
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Fibonacci().fibonacciDP(i));

        }
    }

    public int fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int fibonacciWithMemo(int n) {

        if (n < 2) {
            map.put(n, n);
            return n;
        }
        if (n == 2) {
            map.put(2, 1);
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int ans = fibonacciWithMemo(n - 1) + fibonacciWithMemo(n - 2);
        map.put(n, ans);
        return ans;
    }

    public int fibonacciDP(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
