package CompanyExaminationBank.leetcode.Huawei;

import java.util.Stack;

/**
 * @author chenmengliang
 * @date 2020/3/9 21:24
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 **/
public class _394_DecodeString {
    public static void main(String[] args) {
        _394_DecodeString decodeString = new _394_DecodeString();
        //System.out.println(decodeString.decodeString("3[a]2[bc]"));
        //System.out.println(decodeString.decodeString("3[a2[c]]"));
        //System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString.decodeString("10[leetcode]"));
    }

    /**
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        // 用于存储字符串临时结果
        StringBuilder tempString = new StringBuilder();
        // 用于存储每次要将当前字符串扩展几倍
        StringBuilder lenStringBuilder = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for (char item :
                s.toCharArray()) {
            if (item != ']'){
                stack.push(String.valueOf(item));
            }else {
                tempString.setLength(0);
                // 遇到] 就把与之匹配的[ 之间的弹出栈
                while (!stack.peek().equals("[")){
                    tempString.append(stack.pop());
                }
                // 弹出[
                stack.pop();
                // [ 前面一定是数字，但是注意，数字不一定是只有一位的！！！！！
                // 而且这样的数字在栈中一定是一位一位存的
                lenStringBuilder.setLength(0);
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))){
                    lenStringBuilder.append(stack.pop());
                }
                int len = Integer.parseInt(lenStringBuilder.reverse().toString());
                // 复制
                tempString.append(String.valueOf(tempString).repeat(Math.max(0, len - 1)));
                // 将本次处理结果重新入栈，存储的每次结果都是倒序的
                stack.push(tempString.toString());
            }

        }
        // 重新将存储结果中的所有数据挨个弹出
        // 由于每次存储都是倒叙的（因为每次都是从栈中依次弹出的），因此最后需要reverse一下
        tempString.setLength(0);
        while (!stack.isEmpty()) {
            tempString.append(stack.pop());
        }
        // 最后将结果反过来
        return tempString.reverse().toString();
    }
}
