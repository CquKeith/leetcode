import java.util.HashMap;
import java.util.Map;

/**
 * @author Keith
 * @date 2019/8/7 14:32
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {

        String[] strings = {"dvdf", " ", "abcabcbb", "bbbbb", "pwwkew","abba"};
        for (String s :
                strings) {
            System.out.print(s + ":");
            System.out.println(lengthOfLongestSubstring(s));
        }


    }


    /**
     * 方法一：挨个将每个字符存入一个数据结构中
     *
     * @param s
     * @return 最大不重复子串的长度
     */
    private static int lengthOfLongestSubstring(String s) {
        int maxSubstringLength = 0, strLength = s.length();

        //滑动窗口的起始
        int start = 0, end = 0;
        //key  :    s中的每个字符
        //value:    该字符在s中的索引
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < strLength; i++) {
            char ch = s.charAt(i);
            end = i;
            //从[start,end]之间有出现过该字符则滑动
            if (map.containsKey(ch)) {
                //abba 当判断最后一个a时，start在第二个b 也就是index=2，而map.get(a)=0,所以要选择最靠后（最新的）的start（也即2）
                start = Math.max(start,map.get(ch) + 1);
            }
            maxSubstringLength = Math.max(maxSubstringLength, end - start + 1);

            map.put(ch, i);
        }

        return maxSubstringLength;
    }
}
