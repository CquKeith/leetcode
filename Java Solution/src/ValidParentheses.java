import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2019/9/3 21:54
 **/
public class ValidParentheses {
    public static void main(String[] args) {

        String[] tests = {"()","()[]{}","(]","([)]","{[]}"};
        ValidParentheses validParentheses = new ValidParentheses();
        for (String s :
                tests) {
            System.out.println(s+" : "+validParentheses.isValid(s));
        }



    }

    /**
     * 通过栈：每当一个元素A准备push时，若栈定元素B跟A匹配，则将B 出栈 A也不会入栈
     *          否则将A入栈
     * @param s
     * @return
     */
    private boolean isValid(String s){
        if (s.isEmpty()){
            return true;
        }
        //奇数个 一定不匹配
        if (s.length() % 2 != 0){
            return false;
        }


        //构建括号匹配的字典
        Map<Character,Character> parenthesMap = new HashMap<>(3);
        parenthesMap.put('{','}');
        parenthesMap.put('(',')');
        parenthesMap.put('[',']');

        Stack<Character> stack = new Stack<>();

        for (Character c :
                s.toCharArray()) {
            if (!stack.isEmpty() && c.equals(parenthesMap.get(stack.peek()))){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
