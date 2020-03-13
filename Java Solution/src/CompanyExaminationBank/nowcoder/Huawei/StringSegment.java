package CompanyExaminationBank.nowcoder.Huawei;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2020/3/13 16:05
 * 字符串分割
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7?tpId=37&tqId=21227&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * <p>
 * 示例1
 * 输入
 * abc
 * 123456789
 * 输出
 * abc00000
 * 12345678
 * 90000000
 **/
public class StringSegment {
    public static void main(String[] args) {
        StringSegment stringSegment = new StringSegment();
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[2];
        strings[0] = scanner.nextLine();
        strings[1] = scanner.nextLine();
        stringSegment.segment(strings);
    }

    /**
     * @param strings
     */
    public void segment(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            int index = 0;
            String currentLine = strings[i];
            int chunks = currentLine.length() / 8;

            // 整段的
            while (index < chunks) {
                System.out.println(currentLine.substring(8 * index, 8 * (index + 1)));
                index++;
            }
            // 剩下的补充0
            if (currentLine.length() % 8 != 0) {
                String left = currentLine.substring(currentLine.length() / 8 * 8);
                System.out.print(left);
                for (int j = left.length(); j < 8; j++) {
                    System.out.print("0");
                }
                System.out.println();
            }
        }

    }
}
