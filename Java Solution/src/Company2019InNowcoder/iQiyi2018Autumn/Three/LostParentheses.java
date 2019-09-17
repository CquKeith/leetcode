package Company2019InNowcoder.iQiyi2018Autumn.Three;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2019/9/17 21:46
 *  爱奇艺2018秋季校招java工程师（第三场）
 * 缺失的括号
 **/
public class LostParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        for (Character c :
                s.toCharArray()) {
            if (')' == c && !stack.empty() && '(' == stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        System.out.println(stack.size());

    }
}
