package Topic.StringsTopic;

/**
 * @author chenmengliang
 * @date 2020/3/5 22:08
 * 58. 最后一个单词的长度
 * https://leetcode-cn.com/problems/length-of-last-word/
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 *
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 **/
public class _58_LengthOfLastWord {
    public static void main(String[] args) {
        _58_LengthOfLastWord lengthOfLastWord = new _58_LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord.lengthOfLastWord("1212a"));
    }

    /**
     * 从右向左遍历，遇到第一个字母开始计数，遇到非字母时停止
     * @param s
     * @return 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {

        int right = -1, left = 0;
        for (int i = s.length()-1; i >= 0; --i) {
            // 设置右边界
            if (right == -1 && Character.isLetter(s.charAt(i))) {
                right = i;
            }
            if (right != -1 && !Character.isLetter(s.charAt(i))) {
                left = i+1;
                break;
            }
        }
        return right-left+1;
    }
}
