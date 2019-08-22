package Tencent2019AutumnRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/17/2019 19:40
 **/
public class Four {
    public static void main(String  args[]){
        new Four().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] high = new int[n];
        for (int i = 0; i < n; i++) {
            high[i] = scanner.nextInt();
        }
        //
        for (int i = 0; i < n; i++) {
            //能看到的楼 总个数
            int num = 1;
            //当前看到的最高的楼的高度
            int currentHighest = 0;

            //往左走
            for (int j = i-1; j >= 0 ; j--) {
                if (high[j] > currentHighest){
                    num++;
                    currentHighest = high[j];
                }
            }
            //往右走
            currentHighest = 0;
            for (int j = i+1; j < n; j++) {
                if (high[j] > currentHighest){
                    num++;
                    currentHighest = high[j];
                }
            }
            System.out.print(num+" ");
        }


        scanner.close();
    }
}
