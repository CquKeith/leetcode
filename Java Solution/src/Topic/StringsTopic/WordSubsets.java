package Topic.StringsTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/9/9 10:54
 * [916. 单词子集](https://leetcode-cn.com/problems/word-subsets/)
 **/
public class WordSubsets {
    public static void main(String[] args) {
        String [] A = {"amazon","apple","facebook","google","leetcode"};
        //String [] B = {"e","o"};
        //String [] B = {"e","l"};
        //String [] B = {"e","oo"};
        //String [] B = {"eo","lo"};
        String [] B = {"ec","oc","ceo"};
        System.out.println(new WordSubsets().wordSubsets(A,B));
    }

    /**
     * 算法：
     *      1. 统计B中每个字符串 出现次数最多的频率 因为最多的能够满足，肯定少的也能满足
     *      2. 统计A中每个字符串 出现的频率是否能够>=B中该字符 出现的最多次数
     * @param A
     * @param B
     * @return
     */
    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> ans = new ArrayList<>();

        //初始化一个空的 存放B中每个字符串 出现字符次数最多的
        int[] bMax = count("");

        // 统计B中每个字符串b1 b2 b3中分别出现'a' 'b'...出现最多的次数
        //比如b1中出现'a'1次 b2中出现'a'2次 b3中出现'a'5次，则B中出现'a'最多是5次
        //那么A中的每个单词 出现'a'的频率只要钥匙5次 才能满足条件
        //而且A中的单词 要满足B中所有种类字符 的最高次数 是"且"的关系 才能满足题意
        for (String s :
                B) {
            int[] b = count(s);
            for (int i = 0; i < 26; i++) {
                bMax[i] = Math.max(bMax[i],b[i]);
            }
        }
        for (String item :
                A) {
            //当前字符串是否满足条件
            boolean shouldAdd = true;
            //得到当前字符串的字符出现的频率
            int [] a = count(item);
            for (int i = 0; i < 26; i++) {
                if (a[i] < bMax[i]){
                    shouldAdd = false;
                    break;
                }
            }
            if (shouldAdd){
                ans.add(item);
            }
        }
        return ans;

        
    }

    /**
     * 统计 s中 每个字符出现的频率
     * @param s
     * @return 返回长度是26（总共26种小写字母）出现的词频
     */
    private int[] count(String s){
        int[] ans = new int[26];
        for (char c:
                s.toCharArray()){
            ans[c-'a']++;
        }
        return ans;
    }

        /**
         * 方法一：
         *      超时！！！！废弃掉
         * @param A
         * @param B
         * @return
         */
    public List<String> wordSubsetsSolution1(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        for(String item:
             A) {
            boolean eachOfBisSubSetOfA = true;
            for (String pattern:
                B){
                if (!isSubSet(item,pattern)){
                    eachOfBisSubSetOfA = false;
                    break;
                }
            }
            if (eachOfBisSubSetOfA){
                ans.add(item);
            }

        }
        return ans;
    }

    /**
     *
     * @param src
     * @param pattern
     * @return pattern 是不是src的子集，也即pattern的每个字符都在src中出现过,包括pattern中重复出现的字符
     *
     */
    private boolean isSubSet(String src,String pattern){
        //每次出现的index不能是一样的
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(src);

        for (Character ch :
                pattern.toCharArray()) {
            int index = stringBuilder.indexOf(ch+"");
            if (index == -1){
                return false;
            }
            stringBuilder.deleteCharAt(index);
        }
        return true;
    }
}
