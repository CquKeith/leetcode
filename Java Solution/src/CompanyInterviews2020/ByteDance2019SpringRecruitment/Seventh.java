package CompanyInterviews2020.ByteDance2019SpringRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/10/2019 6:15 PM
 **/
public class Seventh {

    private void solution(){

        Scanner scanner = new Scanner(System.in);
        //最后能量为0，开始时的能量就最小
        double energy = 0;
        int num = scanner.nextInt();
        List<Integer> highList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            highList.add(scanner.nextInt());
        }
        //最后一个为0 倒推回去
        for (int i = num - 1; i >= 0; --i) {
            energy = Math.ceil((highList.get(i)+energy)/2);
        }

        System.out.println((int)energy);

    }





    public static void main(String args[]) {
        new Seventh().solution();
    }
}
