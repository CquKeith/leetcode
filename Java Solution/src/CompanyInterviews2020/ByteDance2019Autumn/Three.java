package CompanyInterviews2020.ByteDance2019Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/11/2019 6:53 PM
 **/
public class Three {
    private void solution(){
        Scanner scanner = new Scanner(System.in);

        //员工个数
        int N = scanner.nextInt();
        //年薪总和
        int sum = 0;
        List<Integer> everyOneTimeList = new ArrayList<>(N);
        List<Integer> everyOneSalaryList = new ArrayList<>(N);
        //刚开始都是100
        for (int i = 0; i < N; i++) {
            everyOneSalaryList.add(100);
            everyOneTimeList.add(scanner.nextInt());

        }

        if (N>1){

            //调整
            for (int i = 1; i < N-1; i++) {
                int last = everyOneTimeList.get(i-1);
                int cur = everyOneTimeList.get(i);
                int next = everyOneTimeList.get(i+1);
                if (cur > last || cur > next){
                    everyOneSalaryList.set(i,Math.max(everyOneSalaryList.get(i-1),everyOneSalaryList.get(i+1))+100);
//                    sum += everyOneSalaryList.get(i);
                }
                if (i==N-2 && next > cur){
                    everyOneSalaryList.set(N-1,everyOneSalaryList.get(i)+100);
//                    sum += everyOneSalaryList.get(N-1);
                }
            }

        }


        sum = 0;
        for (int i = 0; i < N; i++) {
            sum += everyOneSalaryList.get(i);
        }


        System.out.println(sum);
        System.out.println(everyOneSalaryList);

        scanner.close();
    }

    public static void main(String args[]){
        new Three().solution();
    }
}
