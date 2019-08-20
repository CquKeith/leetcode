/**
 * @author Keith
 * @date 8/20/2019 17:55
 **/
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().stringPlus2("99", "9"));
    }

    /**
     * 字符串相加
     * 执行用时 : 13 ms , 在所有 Java 提交中击败了 27.53% 的用户
     * 内存消耗 : 36.6 MB , 在所有 Java 提交中击败了85.77%的用户
     *
     * @param num1
     * @param num2
     * @return
     */
    private String stringPlus1(String num1, String num2) {
//        long startTime = System.currentTimeMillis();
        //判空
        if (num1.isEmpty() || "0".equals(num1)) {
            return num2;
        }
        if (num2.isEmpty() || "0".equals(num2)) {
            return num1;
        }

        StringBuilder ans = new StringBuilder();
        //因为要对两个数频繁操作，这里使用StringBuilder来加速操作和节省空间
        StringBuilder num1StringBuilder = new StringBuilder(num1);
        StringBuilder num2StringBuilder = new StringBuilder(num2);
        //进位
        int carry = 0;
        while (num1StringBuilder.length() != 0 || num2StringBuilder.length() != 0 || carry != 0) {
            if (num1StringBuilder.length() != 0) {
                carry += num1StringBuilder.charAt(num1StringBuilder.length() - 1) - '0';
                num1StringBuilder.deleteCharAt(num1StringBuilder.length() - 1);
            }
            if (num2StringBuilder.length() != 0) {
                carry += num2StringBuilder.charAt(num2StringBuilder.length() - 1) - '0';
                num2StringBuilder.deleteCharAt(num2StringBuilder.length() - 1);
            }

            //每次都插在最前面，后面的都要移动，很浪费时间
            //不过刚开始每次都插入最后面，最后返回结果的时候做一次反转就行
//            ans.insert(0,carry%10);
            ans.append(carry % 10);
            carry /= 10;
        }
        long endTime = System.currentTimeMillis();

//        System.out.println(endTime - startTime);

        return ans.reverse().toString();
    }

    /**
     * 方法二 不将num1 num2转成StringBuilder，然后再一个一个删除
     * 直接遍历
     *
     * @param num1
     * @param num2
     * @return
     */
    private String stringPlus2(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        //判空
        if (num1.isEmpty() || "0".equals(num1)) {
            return num2;
        }
        if (num2.isEmpty() || "0".equals(num2)) {
            return num1;
        }
        //chars1 保存最长的
        char[] chars1, chars2;
        if (num1.length() > num2.length()) {
            chars1 = num1.toCharArray();
            chars2 = num2.toCharArray();
        } else {
            chars1 = num2.toCharArray();
            chars2 = num1.toCharArray();
        }
        int index2 = chars2.length - 1;
        int index1 = chars1.length - 1;
        int carry = 0;
        while (index2 >= 0 || index1 >=0 || carry!=0) {
            if (index2>=0){
                carry += chars2[index2--] + chars1[index1--] - '0' - '0';
            }else if (index1>=0){
                carry += chars1[index1--]-'0';
            }
            ans.append(carry % 10);
            carry /= 10;
        }
        return ans.reverse().toString();
    }
}