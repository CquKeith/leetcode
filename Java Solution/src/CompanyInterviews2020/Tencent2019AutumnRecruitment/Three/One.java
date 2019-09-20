package CompanyInterviews2020.Tencent2019AutumnRecruitment.Three;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-20 20:02
 * 90%
 **/
public class One {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examplesNum = scanner.nextInt();

        for (int i = 0; i < examplesNum; i++) {
            System.out.println(solution(scanner.nextInt(), scanner.next()));
        }
    }

    private static String solution(int curNumberLength, String str) {
        if (curNumberLength < 11) {
            return "NO";
        }
        int index = str.indexOf('8');
        if (index != -1 && index <= curNumberLength - 11){
            return "YES";
        }else {
            return "NO";
        }


        //for (int i = 0; i <= curNumberLength - 11; i++) {
        //    if ('8' == str.charAt(i)) {
        //        return "YES";
        //    }
        //}
        //return "NO";

    }
}
