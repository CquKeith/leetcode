package CompanyInterviews2020.Tencent2019AutumnRecruitment.Three;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-20 20:18
 * 0%
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> delayTimeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            int time = scanner.nextInt();
            for (int j = 0; j < num; j++) {
                delayTimeList.add(time);
            }
        }

        //排序 最大和的配对
        delayTimeList.sort(null);

        int ans = 0;
        int size = delayTimeList.size();
        int halfSize = size >> 1;
        for (int i = 0; i < halfSize; i++) {
            ans = Math.max(ans,delayTimeList.get(i) + delayTimeList.get(size-1 - i));
        }
        System.out.println(ans);
    }
}
