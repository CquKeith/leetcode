package Company2019InNowcoder.Didi2017AutumnRecruitment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/30/2019 15:27
 * 十进制 M（32位整数） 转换成给定的进制N（2<=N<=16）
 **/
public class Decimal2AnyOtherRadix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        //负数变成整数之后在求解
        if (m<0) {
            m = -m;
            System.out.print("-");
        }

        new Decimal2AnyOtherRadix().solution(m, n);
    }

    private void solution(int decimalNum, int targetRadix) {
        StringBuilder stringBuilder = new StringBuilder();
        //定义10->A ,11 -> B等字典
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < 16; i++) {
            if (i < 10) {
                map.put(i, (char) (i + '0'));
            } else {
                map.put(i, (char) (i - 10 + 'A'));
            }
        }

        //从低位开始计算
        while (decimalNum != 0) {
            stringBuilder.append(map.get(decimalNum % targetRadix));
            decimalNum /= targetRadix;
        }
        System.out.println(stringBuilder.reverse().toString());


    }
}
