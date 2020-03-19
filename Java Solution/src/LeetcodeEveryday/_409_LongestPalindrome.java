package LeetcodeEveryday;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/3/19 23:50
 * https://leetcode-cn.com/problems/longest-palindrome/
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 **/
public class _409_LongestPalindrome {
    public static void main(String[] args) {
        _409_LongestPalindrome longestPalindrome = new _409_LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome.longestPalindrome("ccc"));
    }

    /**
     * 贪心算法：
     * 先统计每次字母出现的频率
     * 然后加上所有频率是偶数的（放两边）
     * 如果有频率有奇数的话最后再加一（放最中间）
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int ans = 0;

        for (Integer v : map.values()) {
            // 只加偶数
            ans += v / 2 * 2;
            if ((v & 1) == 1 && (ans & 1) == 0) {
                // 如果v是奇数，而且当前ans是偶数，就加一次
                // 这样也保证了如果有奇数次的话，ans加1且只加一次
                ans += 1;
            }
        }

        return ans;

    }
}
