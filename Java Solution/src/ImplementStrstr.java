/**
 * @author chenmengliang
 * @date 2019/9/3 22:25
 * 28.实现strstr https://leetcode-cn.com/problems/implement-strstr/
 **/
public class ImplementStrstr {
    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().strStr("hello","ll"));
    }

    /**
     *
     * @param haystack
     * @param needle
     * @return needle 在haystack中首次出现的index
     */
    private int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        int left = 0,right = needle.length()-1;
        boolean success = false;
        while (right < haystack.length()){
            if (needle.equals(haystack.substring(left,right+1))){
                success = true;
                break;
            }
            left++;
            right++;
        }
        return success?left:-1;
    }
}
