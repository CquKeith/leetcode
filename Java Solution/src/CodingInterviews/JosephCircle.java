package CodingInterviews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-10-04 12:11
 * 约瑟夫环问题
 * 输入n m
 * n个人 编号0～n-1 循环遍历 ，编号是0的的人开始报数，从1开始报数
 * 当前排队是m的倍数就输出
 * 最后留下来的人的编号
 * 如8 3 输出6
 * https://www.nowcoder.com/questionTerminal/b28d83bef5414b7f814ae76c66b66ff8
 **/
public class JosephCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> list = new LinkedList<>();

        JosephCircle josephCircle = new JosephCircle();
        System.out.println(josephCircle.josephCircleDPSolution(n,m));
        //System.out.println(list);

    }

    /**
     * 使用链表解决
     * TLE 60%
     * @param n 数字1~n
     * @param m 每隔m出局一个
     * @param list 作为返回值，返回输出的顺序
     * @return 返回最后输出的数值
     */
    private int josephCircleLinkedListSolution(int n,int m,List<Integer> list){

        List<Integer> helperList = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            helperList.add(i);
        }
        int index = 0;
        while (!helperList.isEmpty()){
            index = (index + m - 1) % helperList.size();
            list.add(helperList.get(index));
            helperList.remove(index);
        }

        return list.isEmpty()?0:list.get(list.size()-1)-1;
    }

    /**
     * 递归的方式解决
     * @param n
     * @param m
     * @return
     */
    private int josephCircleRecursiveSolution(int n,int m){
        if (n == 1){
            //编号从0开始的
            return 0;
        }
        return (josephCircleRecursiveSolution(n-1,m) + m ) % n;
        //编号如果从1开始 则应该是下面的
        //return (josephCircleRecursiveSolution(n-1,m,list) + m - 1) % n + 1;
    }
    private int josephCircleDPSolution(int n, int m){
        if (n == 1){
            //编号从0开始的
            return 0;
        }
        int []dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = (dp[i-1]+m)%i;
        }
        return dp[n];
    }

}
