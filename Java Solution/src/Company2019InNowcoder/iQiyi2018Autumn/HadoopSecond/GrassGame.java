package Company2019InNowcoder.iQiyi2018Autumn.HadoopSecond;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/18 15:57
 * * 爱奇艺2018秋季校招hadoop工程师（第二场）
 *  * [编程题]青草游戏
 **/
public class GrassGame {
    private static String[] names = {"niu","yang"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(solution(scanner.nextInt()));
        }
        scanner.close();
    }

    /**
     * 1. 当N%5==1或N%5==4，牛牛都可以把草的数量变为0，而羊羊面对0的草堆必输，因此牛牛必赢。 
     * 2. 当N%5==0，牛牛只能吃1或4，因此牛牛吃完后，剩余的草量只能为1或4，对于两种情况，羊羊都能在吃完之后使剩余数量为0。正好与第一种情况互补，因此羊羊必赢。
     * 3. 当N%5==2，牛牛只能把草的数量变为1或者3（2-4+5），此时他当然只能选择3，如此羊羊可以选择吃1个草来使得N==2，因此羊羊可以做到：使牛牛始终面临的草量都为2，其中特殊情况即2，因此羊羊必赢。
     * 4. 当N%5==3，牛牛可以吃1个草，使得羊羊面临N%5==2的情况，正好与第三种情况互补，因此牛牛必赢。
     * @param num
     * @return
     */
    private static String solution(int num){
        return Arrays.asList(1,3,4).contains(num%5)? "niu":"yang";
    }
    private static String solutionWrong(long num){
        int ans = 0;

        // 除4 看多少轮可以化为 4之内的数 牛牛先玩
        long cycles = num / 4;
        //对4 取余
        long mod    = num % 4;
        //一个循环，下面还是牛牛先玩
        if (cycles % 2 == 0){
            //下面大家只能每次出 1
            //还剩奇数个 牛牛获胜
            return names[(int)(1-mod%2)];
        }else {
            //下面到羊羊玩
            //奇数个 羊羊获胜
            return names[(int)(mod%2)];
        }
    }
}
