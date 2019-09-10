package Topic.ArrayTopic;

import java.util.Arrays;

/**
 * @author chenmengliang
 * @date 2019/9/10 16:08
 * [66. 加一](https://leetcode-cn.com/problems/plus-one/)
 **/
public class PlusOne {
    public static void main(String[] args) {
        int [][]tests = {
                //{1,2,3},
                //{4,2,3,1},
                {9,9}};
        for (int[] test :
                tests) {
            System.out.println(Arrays.toString(new PlusOne().plusOne(test)));
        }
    }
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >=0 ; i--) {
            carry += digits[i];
            digits[i] = carry % 10;
            carry /= 10;
        }
        if (carry != 0){
            int [] ans = new int[digits.length+1];
            ans[0] = carry;
            System.arraycopy(digits,0,ans,1,digits.length);
            return ans;
        }
        return digits;
    }
}
