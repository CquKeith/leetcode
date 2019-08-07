import java.util.HashMap;
import java.util.Map;

/**
 * @author Keith
 * @date 2019/8/7 14:32
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String args[]) {

        String[] strings = {"dvdf"," ","abcabcbb", "bbbbb", "pwwkew"};
        for (String s :
                strings) {
            System.out.print(s + ":");
            System.out.println(lengthOfLongestSubstring(s));
        }


    }


    /**
     * 方法一：挨个将每个字符存入一个数据结构中
     * 每次插入新的字符时判断之前是否出现过
     * 如果出现过，则清空之前的数据结构，长度从现在开始重新算
     * 如果没有出现过，则继续
     *
     * @param s
     * @return 最大不重复子串的长度
     */
    private static int lengthOfLongestSubstring(String s) {
        //保存历史中，最长子串的长度
        int maxLenth = 0;

        //为了快速找到当前字符之前是否出现过，使用HashMap来存储
        //HashMap中Key是s[i]，value取i
        Map<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            //如果当前字符重复了，则剔除掉上一个相同字符及之前的部分
            if (hashMap.containsKey(c)){
                //删除掉c字符和c之前的所有字符
                int index = hashMap.get(c);
                for (int j = 0; j < index; j++) {

                }
            }
            //更新maxLenth
            //不管是否重复，都要更新一下最新的maxLenth，并将最新的字符存入HashMap
            hashMap.put(c,i);
            maxLenth = Math.max(maxLenth,hashMap.size());
        }
        return maxLenth;
    }
}
