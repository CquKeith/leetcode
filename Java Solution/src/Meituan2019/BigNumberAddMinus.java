package Meituan2019;

import java.util.Scanner;

/**
 * 字符串加法
 *
 * @author Keith
 **/
public class BigNumberAddMinus {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //
        //String n1 = scanner.nextLine();
        //String n2 = scanner.nextLine();
        //
        //System.out.println(stringPlus(n1, n2));
        System.out.println(stringPlus("-1","20"));

    }

    /**
     * 大数加法
     * 从后往前加 最后反转输出
     *
     * @param num1
     * @param num2
     * @return 返回s1+s2的字符串
     */
    public static String stringPlus(String num1, String num2) {
        //assert
        if (num1.isEmpty() || "0".equals(num1)) {
            return num2;
        }
        if (num2.isEmpty() || "0".equals(num2)) {
            return num1;
        }

        if (num1.charAt(0) == '-' && num2.charAt(0) != '-') {
            return stringMinus(num2, num1.substring(1));
        }
        if (num1.charAt(0) != '-' && num2.charAt(0) == '-') {
            return stringMinus(num1, num2.substring(1));
        }

        StringBuilder ans = new StringBuilder();

        if (num1.length() < num2.length()) {
            return stringPlus(num2, num1);
        }

        //chars1 保存最长的
        char[] chars1, chars2;

        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            chars1 = num1.substring(1).toCharArray();
            chars2 = num2.substring(1).toCharArray();
        } else {
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        }

        //从低位开始加
        int index1 = chars1.length - 1;
        int index2 = chars2.length - 1;
        //进位
        int carry = 0;
        while (index2 >= 0 || index1 >= 0) {
            //index2 > index1
            if (index2 >= 0) {
                carry += chars2[index2--] - '0';
            }
            if (index1 >= 0) {
                carry += chars1[index1--] - '0';
            }
            ans.append(carry % 10);
            carry /= 10;
        }
        if (carry == 1){
            ans.append("1");
        }

        if (num1.charAt(0) == '-' && num2.charAt(0) == '-') {
            ans.append('-');
        }

        return ans.reverse().toString();
    }

    /**
     * @param num1
     * @param num2
     * @return num1 - num2
     */
    public static String stringMinus(String num1, String num2) {
        //assert
        if (num1.isEmpty() || "0".equals(num1)) {
            return "-" + num2;
        }
        if (num2.isEmpty() || "0".equals(num2)) {
            return num1;
        }
        //规定 长的 - 短的
        //也就是num1 一定不短于num2
        if (num1.length() < num2.length()) {
            return "-" + stringMinus(num2, num1);
        }

        if (num1.equals(num2)) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        while (index1 >= 0 || index2 >= 0) {
            if (index2 >= 0) {
                carry += num1.charAt(index1--) - num2.charAt(index2--);
                //需要借位
                if (carry < 0) {
                    //有位可以借
                    if (index1 >= 0) {
                        ans.append(carry + 10);
                        carry = -1;
                    }else{//没有位可以借了
                        ans.append(carry*-1);
                        ans.append("-");
                        break;
                    }
                }
                //不需要借位
                else {
                    ans.append(carry);
                    carry = 0;
                }
            }
            //num2已经减完了 剩下num1的了
            else {
                carry += num1.charAt(index1--) - '0';
                //需要借位
                if (carry < 0) {
                    ans.append(carry + 10);
                }
                //不需要借位
                else {
                    ans.append(carry);
                }
            }
        }


        return ans.reverse().toString();
    }
}
