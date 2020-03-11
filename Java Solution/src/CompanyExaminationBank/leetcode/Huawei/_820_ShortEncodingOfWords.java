package CompanyExaminationBank.leetcode.Huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2020/3/11 15:04
 * 820. 单词的压缩编码
 * https://leetcode-cn.com/problems/short-encoding-of-words/
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 **/
public class _820_ShortEncodingOfWords {
    public static void main(String[] args) {
        _820_ShortEncodingOfWords shortEncodingOfWords = new _820_ShortEncodingOfWords();
        System.out.println(shortEncodingOfWords.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(shortEncodingOfWords.minimumLengthEncoding(new String[]{"me", "time"}));
    }


    /**
     * 后缀
     * 先将所有words存储set
     * 然后排除那些是其他单词后缀的词
     * 最后返回set中所有单词的长度和+set的长度（每个单词对应一个#）
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));

        // 移除word x是word y的后缀的 word x
        for (String word : words) {
            // 从1开始，避免了从set中移除word本身
            // 而word包含了其他单词，那么满足这样条件的单词一定是word的真子串
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int sum = 0;
        for (String string : set) {
            sum += string.length() + 1;
        }
        return sum;
    }

}
