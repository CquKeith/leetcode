import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-01 18:24
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 5. 最长回文子串
 **/
public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(new LongestPalindromicSubstring().longestPalidromImprove(scanner.nextLine()));

        scanner.close();
    }

    /**
     * 算法一：选取一个中心，往两边扩散
     *
     * @param str
     * @return
     */
    private String longestPalindrome(String str) {
        StringBuilder longestSubPaliString = new StringBuilder();
        if (str.length() <= 1) {
            return str;
        }

        int left, right;
        //center 是一个区间，区间里放着相同的字符
        int centerLeft = 0;
        int centerRight;
        longestSubPaliString.append(str.charAt(0));
        while (centerLeft < str.length()) {

            //找后面连续相同的
            centerRight = centerLeft;
            while (centerRight + 1 < str.length() && str.charAt(centerRight) == str.charAt(centerRight + 1)) {
                centerRight++;
                //初始化logestSubPaliString  连续相同的
                if (centerRight - centerLeft + 1 > longestSubPaliString.length()) {
                    longestSubPaliString.setLength(0);
                    longestSubPaliString.append(str, centerLeft, centerRight + 1);
                }
            }

            //开始往两边扩散
            left = centerLeft - 1;
            right = centerRight + 1;

            //剩下的 不可能比当前所得的还要长了
            //if (Math.min(str.length() - centerRight + 1,centerLeft+1) < longestSubPaliString.length()) {
            //    break;
            //}

            while (left >= 0 && right < str.length()) {
                //substring 求的是左开右闭
                if (str.charAt(left) == str.charAt(right)) {
                    //更新最长回文子串
                    if (right - left + 1 > longestSubPaliString.length()) {
                        longestSubPaliString.setLength(0);
                        longestSubPaliString.append(str, left, right + 1);
                    }
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            centerLeft++;

        }
        return longestSubPaliString.toString();
    }

    /**
     * 判断字符串是否回文
     *
     * @param str
     * @return
     */
    private boolean isPalindromic(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.reverse();
        return str.equals(sb.toString());
    }

    /**
     * 算法二：动态规划解法
     * P[i][j]表示子串[i,j]是回文子串
     * 则：
     * P[i][i] = 1
     * P[i][i+1] = 1 if s[i] == s[i+1]
     * P[i][j] = 1 if P[i+1,j-1] == 1 and s[i] == s[j]
     */
    private String longestPalindromeDPSolution(String s) {
        //记录最长的回文子串的开始
        int start = 0;
        //最长回文子串的长度
        int maxLength = 0;
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        boolean[][] P = new boolean[length][length];
        //找出所有的P的概率
        for (int j = 0; j < length; j++) {
            int i = 0;
            while (i <= j) {
                boolean b = (j == i + 1 && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && i < length - 1 && j >= 1 && P[i + 1][j - 1] || i == j);
                P[i][j] = b;
                if (b) {
                    int current = j - i + 1;
                    if (current > maxLength) {
                        maxLength = current;
                        start = i;
                    }
                }
                i++;
            }

        }
        return s.substring(start, start + maxLength);
    }

    /**
     * 算法三：算法一改进版：
     * 中间相同的值可以跳过，不用再次遍历
     *
     * @param s
     * @return
     */
    private String longestPalidromImprove(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        //装着起始位置的数组
        //看别人的测试，用数组传值比使用全局变量快一点
        int[] startEndRange = new int[2];
        for (int i = 0; i < s.length(); i++) {
            i = findNextLoc(chars, i, startEndRange);
        }
        return s.substring(startEndRange[0], startEndRange[1] + 1);
    }

    /**
     * 算法三的 找寻下一个位置
     *
     * @param chars 字符串
     * @param low   从哪里开始找起
     * @param range 2个长度的参数，最大长度的起始index，最后可以传出去
     * @return 下一次遍历的位置
     */
    private int findNextLoc(char[] chars, int low, int[] range) {

        int high = low;
        //找一连串 跟当前值一样的
        while (high < chars.length - 1 && chars[low] == chars[high + 1]) {
            high++;
        }
        int ans = high;

        //从中心往两边扩散
        while (high < chars.length - 1 && low > 0 && chars[low - 1] == chars[high + 1]) {
            --low;
            ++high;
        }
        //更新最大长度
        if (high - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }
}
