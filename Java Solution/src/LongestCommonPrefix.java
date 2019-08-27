/**
 * @author Keith
 * @date 8/23/2019 21:56
 * leetcode -14
 * https://leetcode-cn.com/problems/longest-common-prefix/
 **/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
//        System.out.println(strings[1].indexOf(""));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strings));
    }

    /**
     * @param strs
     * @return 算法：讲问题归结为不断的求两个字符串的公共前缀子串问题
     */
    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //初始化公共子串
        StringBuilder stringBuilder = new StringBuilder(strs[0]);
        //逐个与剩下的字符串 两两找寻公共子串
        for (int i = 1; i < strs.length; i++) {
            //当前的公共子串与现在的字符串进行比较，逐个删去最后一个字符
            //indexOf("")返回0，如果不包含该字符串 返回-1，包含的话，返回第一次出现该字符串的index
            while (strs[i].indexOf(stringBuilder.toString()) != 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder.length() == 0) {
                return "";
            }
        }

        return stringBuilder.length() == 0 ? "" : stringBuilder.toString();
    }
}
