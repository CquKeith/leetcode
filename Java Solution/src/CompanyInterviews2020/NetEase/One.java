package CompanyInterviews2020.NetEase;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-21 15:18
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examples = scanner.nextInt();
        for (int i = 0; i < examples; i++) {
            System.out.println(minSumSolution(scanner.nextInt()));
        }
    }

    /**
     * 每次选 小于x的最大一位数 i， 从个位开始
     * 每次操作 x -= i
     * @param x
     * @return
     */
    private static String minSumSolution(int x){
        if (x < 10){
            return x+"";
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (x>=10){
            stringBuilder.append(9);
            x -= 9;
        }
        if (x > 0){
            stringBuilder.append(x);
        }
        return stringBuilder.reverse().toString();
    }
}






















