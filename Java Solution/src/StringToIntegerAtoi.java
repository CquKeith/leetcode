import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-08-30 22:04
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 **/
public class StringToIntegerAtoi {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(new StringToIntegerAtoi().myAtoi(str));
    }

    public int myAtoi(String str) {
        long ans = 0;
        str = str.trim();
        //是否是负值
        boolean isNagative = false;
        if (str.length() == 0) {
            return 0;
        }
        char firstchar = str.charAt(0);
        if (!Character.isDigit(firstchar) && '-' != firstchar && '+' != firstchar) {
            return 0;
        }
        int index=0;
        if ('-' == firstchar){
            isNagative = true;
            index = 1;
        }else if ('+' == firstchar){
            index = 1;
        }

        while (index < str.length()) {

            char c = str.charAt(index);
            if (!Character.isDigit(c)){
                break;
            }
            ans = ans * 10 + (c-'0');
            //溢出了
            if (ans> Integer.MAX_VALUE){
                return isNagative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

            index++;
        }

        return (int) (isNagative?(-1*ans):ans);
    }
}
