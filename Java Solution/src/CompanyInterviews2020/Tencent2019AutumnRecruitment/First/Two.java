package CompanyInterviews2020.Tencent2019AutumnRecruitment.First;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/17/2019 19:40
 **/
public class Two {
    public static void main(String  args[]){
        new Two().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long count = 1<<n;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(String.valueOf(scanner.nextInt()));
        }

        int m = scanner.nextInt();
        List<Integer> list = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();


        String s = stringBuilder.toString();
        for (int i = 0; i < m; i++) {
            int groupSize = 1<<list.get(i);
            s = reverByGroupSize(s,groupSize);

            System.out.println(calcNiXuNum(s));
        }

    }
    private String reverByGroupSize(String s,int groupSize){
        if (groupSize == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()){
            //最后一组 如果长度不够groupSize，则就单独一组
            if (s.length() < groupSize) {
                groupSize = s.length();
            }
            for (int i = groupSize-1; i >= 0; i--) {
                res.append(s.charAt(i));

            }
            s = s.substring(groupSize,s.length());
        }

        return res.toString();
    }
    private long calcNiXuNum(String s){

        long sum = 0L;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (s.charAt(j) < s.charAt(i)){
                    sum ++;
                }
            }
        }

        return sum;
    }
}
