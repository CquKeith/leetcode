package CompanyExaminationBank.nowcoder.Huawei;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2020/3/13 15:50
 * 计算字符个数
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 **/
public class CharacterCountInString {
    public static void main(String[] args) {
        CharacterCountInString characterCountInString = new CharacterCountInString();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String target = scanner.nextLine();
        System.out.println(characterCountInString.countCharacter(line, target.charAt(0)));
    }

    /**
     * 扫描一遍
     *
     * @param string
     * @param target
     * @return
     */
    public long countCharacter(String string, char target) {
        long count = 0L;

        if (null == string || string.length() <= 0) {
            return 0;
        }

        target = Character.toLowerCase(target);
        for (char c : string.toCharArray()) {
            if (Character.toLowerCase(c) == target) {
                count++;
            }
        }

        return count;
    }
}
