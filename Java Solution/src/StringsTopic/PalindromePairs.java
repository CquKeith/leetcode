package StringsTopic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chenmengliang
 * @date 2019/9/9 14:30
 * [336. 回文对](https://leetcode-cn.com/problems/palindrome-pairs/)
 **/
public class PalindromePairs {
    public static void main(String[] args) {
        String[][] tests = {
                            //{"abcd", "dcba", "lls", "s", "sssll"},
                            //{"bat","tab","cat"},
                            //{"",""},
                            {"a",""},
                            //{"a","a"},
                            //{"a","b","c","ab","ac","aa"}
                            };
        for (String[] test:tests){
            System.out.println(new PalindromePairs().palindromePairs(test));
        }
    }

    /**
     * 算法二：
     *      三种情况：
     *          1. 如果自己的翻转后的字符串也在数组里，可以组成一对，注意翻转后不能是自己。
     *          2. 如果某个字符串能找到一个分割点，分割点前的部分是回文，后半部分翻转后也在数组里，可组成一对。
     *          3. 如果某个字符串能找到一个分割点，前半部分翻转后也在数组里，分割点后的部分是回文，可组成一对。
     *
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words){

        List<List<Integer>> ans = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>(words.length);

        for (int i = 0; i < words.length; i++) {
            map.put(words[i],i);
        }

        //是否添加了"" ""这样的两个
        boolean hasAddNullNull = false;

        for (int i = 0; i < words.length; i++) {
            String reversedString = reverseString(words[i]);
            //反转之后不是它本身，但是在words中
            if (map.containsKey(reversedString) && !reversedString.equals(words[i])){
                ans.add(Arrays.stream(new int[]{i,map.get(reversedString)}).boxed().collect(Collectors.toList()));
                continue;
            }
            //如果本身是"" 则匹配每一个 本身就是回文的添加两次
            // 遇到另一个也是"" 的 只需添加1次
            if ("".equals(words[i])){
                for (int j = 0; j < words.length; j++) {
                    if ("".equals(words[j])){
                        if (i!=j && !hasAddNullNull){
                            hasAddNullNull = true;
                            ans.add(Arrays.stream(new int[]{i,j}).boxed().collect(Collectors.toList()));
                        }

                    }else if (isPalindrome(words[i]) && i!=j){
                        ans.add(Arrays.stream(new int[]{i,j}).boxed().collect(Collectors.toList()));
                        ans.add(Arrays.stream(new int[]{j,i}).boxed().collect(Collectors.toList()));
                    }
                }
                continue;
            }



            //word[i] 割点前A是回文，后面反转成为B之后在map中，则可以组成 B AB
            //        割点后A是回文， 前面反转成为B之后在map中，则可以组成 BA B
            //找割点
            for (int j = 0; j < words[i].length(); j++) {
                    String pointBefore = words[i].substring(0,j+1);
                    String pointAfter  = words[i].substring(j+1);
                    String pointBeforeReversed = reverseString(pointBefore);
                    String pointAfterReversed = reverseString(pointAfter);

                    //取真子串
                    //if (pointAfter.length() == words[i].length() || pointBefore.length() == words[i].length()){
                    //    continue;
                    //}

                    //割点前回文 后面部分反转后在map中
                    if (isPalindrome(pointBefore) && map.containsKey(pointAfterReversed) && i!= map.get(pointAfterReversed)){
                        ans.add(Arrays.stream(new int[]{map.get(pointAfterReversed),i}).boxed().collect(Collectors.toList()));
                    }
                    //割点后面回文 前面部分反转之后在map中
                    if (isPalindrome(pointAfter) && map.containsKey(pointBeforeReversed) && i!= map.get(pointBeforeReversed)){
                        ans.add(Arrays.stream(new int[]{i,map.get(pointBeforeReversed)}).boxed().collect(Collectors.toList()));
                    }

            }

        }

        return ans;


    }
    private String reverseString(String s){
        if (s.length() <= 1)return s;

        return new StringBuilder().append(s).reverse().toString();
    }



    /**
     * 暴力解法
     *  果然超时了
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairsForce(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String strA = words[i];

            for (int j = i+1; j < words.length; j++) {
                String strB = words[j];

                if (isPalindrome(strA+strB)){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }

                if (isPalindrome(strB + strA)){
                    List<Integer> list = new ArrayList<>(2);
                    list.add(j);
                    list.add(i);
                    ans.add(list);
                }

            }
        }

        return ans;
    }
    private boolean isPalindrome(String s){

        int size = s.length() / 2;
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

}
