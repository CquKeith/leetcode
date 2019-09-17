import java.util.*;

/**
 * @author chenmengliang
 * @date 2019/9/17 10:47
 **/
public class Zhongxing2 {
    public static void main(String[] args) {
        //System.out.println(new Zhongxing2().calculateScore("5*4-3*2",4,new int[]{-10,10,14,90}));
        System.out.println(new Zhongxing2().equation2Postfix("5*(4-3*2)"));
    }
    public int calculateScore(String equation,int numStudent,int[] answerList){

        int ans = 0;

        Set<Integer> posibleAnswer = calcAllEqaitonsAnswer(equation);
        int correctAnswer = calcAnswer(equation);

        for (int item :
                answerList) {
            if (item == correctAnswer){
                ans += 5;
            }else if (posibleAnswer.contains(item)){
                ans += 2;
            }
        }

        return ans;
    }

    /**
     * 将括号加到 每个可能的位置 并计算出结果
     * @param equation
     * @return
     */
    public Set<Integer> calcAllEqaitonsAnswer(String equation){
        Set<Integer> ans = new HashSet<>();

        //加括号
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < equation.length(); i++) {
            for (int j = i+1; j < equation.length(); j++) {
                if (Character.isDigit(equation.charAt(i)) && Character.isDigit(equation.charAt(j))){
                    stringBuilder.setLength(0);
                    stringBuilder.append(equation);
                    stringBuilder.insert(j+1,')');
                    stringBuilder.insert(i,'(');
                    list.add(stringBuilder.toString());
                    ans.add(calcAnswer(stringBuilder.toString()));
                }
            }
        }
        //System.out.println(list.toString());

        return ans;
    }

    /**
     * 计算带有（） + - *的中序表达式的结果
     * @param equation
     * @return
     */
    public int calcAnswer(String equation){
        Stack<Integer> stack = new Stack<>();
        String postFix = equation2Postfix(equation);
        System.out.println(equation);
        for (Character c :
                postFix.toCharArray()) {
            if (Character.isDigit(c)){
                stack.push(c-'0');
            }else {
                int top = stack.pop();
                int second = stack.pop();
                if ('*' == c){
                    stack.push(second * top);
                }else if ('-' == c){
                    stack.push(second - top);
                }else if ('+' == c){
                    stack.push(second + top);
                }
            }
        }


        return stack.peek();
    }

    /**
     * 中序表达式 -> 后续表达式
     * 5*(4-3*2) -> 5432*-*
     * ( ) - +
     * @param equation
     * @return
     */
    public String equation2Postfix(String equation){
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);
            if (c == '+' || c == '-') {
                if (stack.isEmpty() || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                                   && (stack.peek() == '*' || stack.peek() == '/'
                                               || stack.peek() == '+' || stack.peek() == '-')) {
                        ans.append(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '*' || c == '/') {
                if (stack.isEmpty() || stack.peek() == '+'
                            || stack.peek() == '-' || stack.peek() == '(') {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty()
                                   && (stack.peek() == '/' || stack.peek() == '*')) {
                        ans.append(stack.pop());
                    }
                    stack.push(c);
                }
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                char temp = ' ';
                while ((temp = stack.pop()) != '(') {
                    ans.append(temp);
                }
            } else {
                ans.append(c);
            }
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }
        }


        return ans.toString();
    }
}
