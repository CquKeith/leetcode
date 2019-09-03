package Tencent2019AutumnRecruitment.First;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Keith
 * @date 8/17/2019 19:39
 **/
public class One {
    public static void main(String args[]) {
        new One().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);

        String old = scanner.next();
        System.out.println(parseString(old));


        scanner.close();
    }

    private String parseString(String str) {

        int lenth = str.length();
        if (lenth == 0) {
            return "";
        }
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < lenth; i++) {
            char ch = str.charAt(i);
            if (ch == '[') {
                strStack.push(res.toString());
                res = new StringBuilder();
            } else if (ch == ']') {
                int num = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int j = 0; j < num; j++) {
                    temp.append(res);
                }
                res = temp;
            } else if (Character.isDigit(ch)) {
                int num = 0;
                while (i < lenth && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (ch != '|') {
                res.append(ch);
            }
        }
        return res.toString();


    }


}
