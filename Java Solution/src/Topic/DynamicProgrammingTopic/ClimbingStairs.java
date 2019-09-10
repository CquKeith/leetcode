package Topic.DynamicProgrammingTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2019/9/5 10:36
 * [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)
 **/
public class ClimbingStairs {

    //备忘录
    private Map<Integer,Long> map = new HashMap<>();

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();
        long start = System.currentTimeMillis();

        System.out.println(climbingStairs.climbStairsAnotherDPSolution(10));
        long end = System.currentTimeMillis();

        System.out.println("耗时："+(end - start));

    }

    /**
     * 暴力递归
     * @param n 爬到n阶台阶  每次可以爬1层或者2层
     * @return 有多少种方法
     * f(n) = f(n-1) + f(n-2)
     */
    private long climbStairsForceRecursive(int n){

        if (n<=2){
            return n;
        }
        return climbStairsForceRecursive(n-1)+climbStairsForceRecursive(n-2);
    }

    /**
     * 带有备忘录的递归解法
     * 自顶向下
     * @param n
     * @return
     */
    private long climbStairsRecursiveWithMemo(int n){

        if (map.containsKey(n)){
            return map.get(n);
        }


        long result;

        if (n<=2){
            result = n;
        }
        else{
            result = climbStairsRecursiveWithMemo(n-1)+climbStairsRecursiveWithMemo(n-2);
        }


        map.put(n,result);
        return result;
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     * f(0) = 0
     * f(1) = 1
     * f(2) = 2
     * f(n) = f(n-1)+f(n-2)
     */
    private long climbStairsDPSolution(int n){

        if (n<=2)return n;

        long[] dp = new long[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

    /**
     * 不使用table的DP Solution
     * @param n
     * @return
     */
    private int climbStairsAnotherDPSolution(int n){

        if (n<=2)return n;

        int preNum = 2;
        int prePreNum = 1;
        int index = 3;
        int ans = 0;

        while (index <= n){
            ans = preNum + prePreNum;
            prePreNum = preNum;
            preNum = ans;


            index++;
        }

        return ans;
    }
}
