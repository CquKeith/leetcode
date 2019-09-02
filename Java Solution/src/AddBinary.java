/**
 * @author chenmengliang
 * @date 2019/9/2 21:34
 * 67. 二进制求和 https://leetcode-cn.com/problems/add-binary/
 **/
public class AddBinary {
    public static void main(String[] args) {

        System.out.println(new AddBinary().addBinary("11","1"));
    }

    /**
     * 实现两个二进制数字相加
     * @param str1
     * @param str2
     * @return
     */
    private String addBinary(String str1,String str2){

        StringBuilder stringBuilder = new StringBuilder();

        //char1[] 保存长的
        char[] charsLong,charsShort;
        if (str1.length()>str2.length()){
            charsLong = str1.toCharArray();
            charsShort = str2.toCharArray();
        }else {
            charsLong = str2.toCharArray();
            charsShort = str1.toCharArray();
        }
        int carry = 0;
        int indexLong = charsLong.length - 1;
        int indexShort = charsShort.length - 1;
        while (indexLong >= 0 || indexShort>=0 || carry > 0){
            if (indexLong >= 0){
                carry += charsLong[indexLong] - '0';
                indexLong--;
            }
            if (indexShort >= 0){
                carry += charsShort[indexShort] - '0';
                indexShort--;
            }
            stringBuilder.append(carry%2);
            carry /= 2;
        }

        return stringBuilder.reverse().toString();

    }
}
