/**
 * @author Keith
 * @date 8/20/2019 16:44
 **/
public class MultiplyStrings {
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "456";
        System.out.println(new MultiplyStrings().multiply(s1,s2));
    }
    private String multiply(String num1, String num2) {
        if (num1.isEmpty() || num2.isEmpty() || "0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        String ans = "";

        for (int i = num1.length() - 1; i >= 0; i--) {
            char ch1 = num1.charAt(i);
            //用ch来×num2
            StringBuilder tempStringBuilder = new StringBuilder();
            if (ch1 == '0') {
                tempStringBuilder.append(0);
            }else if (ch1 == '1'){
                tempStringBuilder.append(num2);
            }else {
                int carry = 0;
                for (int j = num2.length()-1; j >= 0; j--) {
                    char ch2 = num2.charAt(j);
                    carry += (ch1-'0')*(ch2 - '0');
                    tempStringBuilder.append(carry%10);
                    carry /=10;
                }
                //处理进位
                if (carry!=0){
                    tempStringBuilder.append(carry);
                }
                //本次计算的结果
                tempStringBuilder.reverse();
            }
            //纠正 ： 123中的2*num2得到的结果 需要纠正：加一个0 同样 1*num时需要加两个0
            //ch1是倒数第几位
            int location = num1.length() - 1 - i;
            for (int j = 0; j < location; j++) {
                tempStringBuilder.append(0);
            }
//            System.out.println(ch1+"*"+num2+"="+tempStringBuilder.toString());
            //更新最终结果
            ans = stringPlus(ans,tempStringBuilder.toString());

        }

        return ans;
    }

    /**
     * 字符串相加
     * @param num1
     * @param num2
     * @return
     */
    private String stringPlus(String num1,String num2){
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
