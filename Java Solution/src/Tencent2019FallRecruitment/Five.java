package Tencent2019FallRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/17/2019 19:40
 **/
public class Five {
    public static void main(String  args[]){
        new Five().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int []company = new int[n];
        int [] fit = new int[n];
        for (int i = 0; i < n; i++) {
            company[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            fit[i] = scanner.nextInt();
        }
        scanner.close();

        //休息天数
        int resetDay = 0;
        int lastWork = -1,lastFit = -1;
        for (int i = 0; i < n; i++) {
            //公司不营业
            if (company[i]==0){
                //健身房不营业
                if (fit[i] == 0){
                    resetDay++;
                }
                //健身房不营业但昨天锻炼过
                else if (i-1 == lastFit){
                    resetDay++;
                }
                else {
                    lastFit = i;
                }
            }
            //公司营业
            else {
                if (fit[i] == 0){
                    if (lastWork == i-1){
                        resetDay++;
                    }
                }else {
                    if (lastFit == i-1){
                        resetDay++;
                    }
                }

            }



        }


        System.out.println(resetDay);
    }
}
