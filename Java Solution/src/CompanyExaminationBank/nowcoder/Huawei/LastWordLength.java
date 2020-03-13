package CompanyExaminationBank.nowcoder.Huawei;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2020/3/13 15:29
 * 字符串最后一个单词的长度
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&tqId=21224&tPage=1&rp=&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 * 题目描述
 * 计算字符串最后一个单词的长度，单词以空格隔开。
 * 输入描述:
 * 一行字符串，非空，长度小于5000。
 *
 * 输出描述:
 * 整数N，最后一个单词的长度。
 *
 * 示例1
 * 输入
 * hello world
 * 输出
 * 5
 **/
public class LastWordLength {
    public static void main(String[] args) {
        LastWordLength lastWordLength = new LastWordLength();
        Scanner scanner = new Scanner(System.in);
        String words = scanner.nextLine();
        System.out.println(lastWordLength.lastWordLength(words));

    }

    /**
     * 倒着遍历，先找最后一个单词的结尾end，在找最后一个单词的开始start
     * end - start + 1就是单词长度
     * @param words
     * @return
     */
    public int lastWordLength(String words) {

        int end = -1;
        int start = 0;
        for (int i = words.length() - 1; i >= 0; i--) {
            // 当前如果是字母，则在end没有确定时确定end的位置
            // 当前不是字母，end也都确定了，则确定start在当前位置的前面
            if (Character.isLetter(words.charAt(i))) {
                if (end < 0) {
                    end = i;
                }
                start = i;
            } else if (end >= 0) {
                // 扫描到了到了不是字母的地方，end>=0说明end已经确定（start也肯定确定了）
                break;
            }
        }

        return end - start + 1;
    }
}
