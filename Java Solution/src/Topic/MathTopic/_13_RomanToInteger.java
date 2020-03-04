package Topic.MathTopic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/3/4 17:38
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 **/
public class _13_RomanToInteger {

    public Map<String, Integer> map = new HashMap<>() {{
        put("I", 1);
        put("IV", 4);
        put("V", 5);
        put("IX", 9);
        put("X", 10);
        put("XL", 40);
        put("L", 50);
        put("XC", 90);
        put("C", 100);
        put("CD", 400);
        put("D", 500);
        put("CM", 900);
        put("M", 1000);
    }};
    public Map<Character, Integer> characterIntegerMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public static void main(String[] args) {
        _13_RomanToInteger romanToInteger = new _13_RomanToInteger();

        System.out.println(romanToInteger.romanToInt2("III"));
        System.out.println(romanToInteger.romanToInt2("IV"));
        System.out.println(romanToInteger.romanToInt2("IX"));
        System.out.println(romanToInteger.romanToInt2("LVIII"));
        System.out.println(romanToInteger.romanToInt2("MCMXCIV"));
        System.out.println(romanToInteger.romanToInt2("D"));
    }

    /**
     * 从左到右扫描，优先一次扫描两个，如果在字典中，就继续往后扫描，否则扫描一个
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        int index = 0;
        int len = s.length();
        while (index < len) {
            if (index + 2 <= len && map.containsKey(s.substring(index, index + 2))) {
                sum += map.get(s.substring(index, index + 2));
                index += 2;
            } else {
                if (map.containsKey(s.substring(index, index + 1))) {
                    sum += map.get(s.substring(index, index + 1));
                    index++;
                }
            }
        }
        return sum;
    }

    /**
     * 字典中不存放4 9 这种映射关系
     * 而是一个一个的扫描，并保存上一个扫描到的值pre，如果pre小于当前的值current，那么上面的一个值应该是负的
     * 比如IV 应该对应-1 5 所以是4
     *
     * @param s
     * @return
     */
    public int romanToInt2(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        int sum = 0;
        int pre = getValueByChar(s.charAt(0));
        int current = pre;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            current = getValueByChar(c);
            if (pre < current) {
                sum -= pre;
            }else {
                sum += pre;
            }
            pre = current;
        }
        sum += current;
        return sum;
    }

    /**
     * 此中方式获取映射，要比hashMap快的多
     * @param c
     * @return
     */
    public int getValueByChar(char c){
        switch (c) {
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}
