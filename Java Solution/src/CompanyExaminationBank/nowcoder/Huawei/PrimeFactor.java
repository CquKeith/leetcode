package CompanyExaminationBank.nowcoder.Huawei;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2020/3/17 18:01
 * 质数因子
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607?tpId=37&tqId=21229&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 *
 *
 * 函数接口说明：
 *
 * public String getResult(long ulDataInput)
 *
 * 输入参数：
 *
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 *
 * String
 *
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 180
 * 输出
 * 2 2 3 3 5
 **/
public class PrimeFactor {
    public static void main(String[] args) {
        PrimeFactor primeFactor = new PrimeFactor();
        Scanner scanner = new Scanner(System.in);
        System.out.println(primeFactor.calcPrimeFactors(scanner.nextLong()));

    }

    /**
     *
     * @param num
     * @return num的质数 从小到大输出
     */
    public String calcPrimeFactors(long num) {

        if (num <= 3) {
            return String.valueOf(num);
        }

        StringBuilder stringBuilder = new StringBuilder();
        long end = (long) Math.sqrt(num);
        for (long i = 2L; i < end && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
                stringBuilder.append(i).append(" ");
            }
        }
        // 如果num本身就是一个质数，则输出他自己
        if (num != 0) {
            stringBuilder.append(num).append(" ");
        }
        return stringBuilder.toString();
    }
}
