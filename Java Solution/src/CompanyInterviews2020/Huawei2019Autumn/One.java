package CompanyInterviews2020.Huawei2019Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/21/2019 18:43
 **/
public class One {
    public static void main(String[] args) {
        new One().solution();
    }
    private void solution() {
//        System.out.println(dec2HexString(17));

        Scanner scanner = new Scanner(System.in);
        //总个数
        int n = scanner.nextInt();
        n -= 1;
        List<String> list = new ArrayList<>(n);
       // 8 1 2 3 4 5 6 A
        for (int i = 0; i < n; i++) {
//            byte b = scanner.nextByte(16);
            String temp = scanner.next();
            temp = temp.toUpperCase();
            if ("A".equals(temp) || "0A".equals(temp)){
                list.add("12");
                list.add("34");
            }else if ("B".equals(temp) || "0B".equals(temp)){
                list.add("AB");
                list.add("CD");
            }else {
                list.add(temp);
            }
        }
        //!!!!!!!!!!!!!!这里也要转成16进制,而且是大写的，否则通过率就只有20%!!!!!!!!!!!!!!!!!!1
        Integer size = list.size() + 1;
        System.out.print(dec2HexString(size)+" ");
        for (String b :
                list) {
            System.out.print(b+" ");
        }


        scanner.close();
    }

    /**
     * 10进制数 转成16进制字符串（大写）
     * @param n
     * @return
     */
    private String dec2HexString(int n){
        StringBuilder ans = new StringBuilder();
        while (n!=0){
            int temp = n % 16;
            n /= 16;
            if (temp<10){
                ans.append(temp);
            }
            else {
                ans.append((char)(temp-10+'A'));
            }
        }
        return ans.toString();

    }
}
