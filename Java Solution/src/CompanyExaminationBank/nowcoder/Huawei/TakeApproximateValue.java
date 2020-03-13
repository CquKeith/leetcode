package CompanyExaminationBank.nowcoder.Huawei;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2020/3/13 16:40
 * 取近似值（四舍五入）
 * https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&tqId=21230&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 5.5
 * 输出
 * 6
 **/
public class TakeApproximateValue {
    public static void main(String[] args) {
        TakeApproximateValue takeApproximateValue = new TakeApproximateValue();
        Scanner scanner = new Scanner(System.in);
        System.out.println(takeApproximateValue.approximateValue(scanner.nextDouble()));
    }

    /**
     *
     * @param value 正浮点数值
     * @return 该数值的近似整数值
     */
    public long approximateValue(double value) {

        // 先舍弃小数点，保留整数部分
        long ans = (long) value;

        // 小数点后第一位
        int afterPointFirstValue = (int) ((long)(value * 10) % 10);

        if (afterPointFirstValue >= 5) {
            ans++;
        }
        return ans;
    }
}
