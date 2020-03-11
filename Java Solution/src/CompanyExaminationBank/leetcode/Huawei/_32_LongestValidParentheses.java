package CompanyExaminationBank.leetcode.Huawei;

/**
 * @author chenmengliang
 * @date 2020/3/9 22:41
 * 32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 * <p>
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 **/
public class _32_LongestValidParentheses {
    public static void main(String[] args) {
        _32_LongestValidParentheses longestValidParentheses = new _32_LongestValidParentheses();
        //System.out.println(longestValidParentheses.longestValidParentheses("()"));
        //System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses("()(())"));
    }

    /**
     * 求最长有效括号的字串！！
     * 不是求有效括号有多少个
     * 解法1：动态规划
     * dp[] 存储每个字符处的最长有效括号的长度
     * 则：
     * if s[i] == '(' dp[i] = 0
     * else
     * // ....()
     * if s[i-1] == '(' then dp[i] = dp[i-2]+2
     * // ...))
     * else
     * // 跳过中间以i已经是有效括号的部分，定位到前一个有效括号的左边
     * lastIndex = i-1-dp[i-1]
     * // 可以和当前的')'配对
     * if s[lastIndex] == '('
     * dp[i] = dp[i-1] + dp[lastIndex] + 2
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        if (s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == ')') {
                // ....()
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i > 1 ? dp[i - 2] + 2 : 2;
                } else {
                    // .....))
                    int lastIndex = i - 1 - dp[i - 1];
                    if (lastIndex >= 0 && s.charAt(lastIndex) == '(') {

                        // dp[lastIndex]是在当前这个'('处的ans，+2是s.charAt(lastIndex)和s.charAt(i) 形成了（），
                        // dp[i-1] 是(lastInd,i)区间内的ans
                        // lastIndex>0时，再加上lastIndex左边的ans，因为()(())这样的也算有效括号
                        //!!!!!!   lastIndex > 0 ? dp[lastIndex - 1] : 0切记要加上括号，否则会是别称
                        // ( dp[lastIndex] + 2 + dp[i - 1] + lastIndex) > 0 ? dp[lastIndex - 1] : 0
                        dp[i] = dp[lastIndex] + 2 + dp[i - 1] + (lastIndex > 0 ? dp[lastIndex - 1] : 0);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
