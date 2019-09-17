package CompanyInterviews2020.ByteDance2019SpringRecruitment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/7/2019 9:23 PM
 * 字节跳动2019春招研发部分编程题汇总 第1题
 **/
public class First {
    public static void main(String args[]) {

        int num;
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();

        ArrayList<String> arrayList = new ArrayList<>(num);

        for (int i = 0; i < num; i++) {
            arrayList.add(scanner.next());
        }

        for (String str :
                arrayList) {
            System.out.println(autoCorrectString(str));
        }

    }

    /**
     * 根据规则矫正
     * 1. AAA  -> AA
     * 2. AABB -> AAB
     * 3.从左到右的优先顺序，如AABBCC中，AABB和BBCC都需要矫正，则先矫正AABB -> AAB
     *
     * @param string
     * @return
     */
    private static String autoCorrectString(String string) {
        StringBuilder result = new StringBuilder();

        if (string.length() < 3) {
            return string;
        }

        result.append(string.substring(0, 2));
        for (int i = 2; i < string.length(); i++) {
            result.append(string.charAt(i));

            int lenth = result.length();
            try {
                // AAA -> AA
                if ((result.charAt(lenth - 1) == result.charAt(lenth - 2)) && (result.charAt(lenth - 1) == result.charAt(lenth - 3))) {
                    result.deleteCharAt(lenth - 1);
                }
                // AABB -> AAB
                if ((result.charAt(lenth - 1) == result.charAt(lenth - 2)) && (result.charAt(lenth - 3) == result.charAt(lenth - 4))) {
                    result.deleteCharAt(lenth - 1);
                }
            }catch (StringIndexOutOfBoundsException e){

            }

        }

        return result.toString();
    }

}
