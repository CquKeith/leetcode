package Topic.ArrayTopic;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2020/2/29 14:50
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 **/
public class _17_LetterCombinationOfAPhoneNumber {


    private Map<Character,String> map = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    private List<String> ansList = new ArrayList<>();


    public static void main(String[] args) {

        _17_LetterCombinationOfAPhoneNumber solution = new _17_LetterCombinationOfAPhoneNumber();

        System.out.println(solution.letterCombinations("23"));

    }

    /**
     * 全排列
     * 通过递归来回溯
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        if (null == digits || digits.length() <= 0){
            return ansList;
        }
        backTrace("",digits);

        return ansList;
    }

    /**
     *
     * @param currentCombination 当前已经形成的组合
     * @param nextDigits 加下来需要组合的数字
     */
    private void backTrace(String currentCombination, String nextDigits) {

        // 如果接下来没有数字要组合来 就返回
        if (nextDigits.length() == 0){
            ansList.add(currentCombination);
            return;
        }

        // 还有数字要组合
        // 取出当前数字对应
        String digitString = map.get(nextDigits.charAt(0));
        for (int i = 0; i < digitString.length(); i++) {
            backTrace(currentCombination+digitString.charAt(i),nextDigits.substring(1));
        }

    }
}
