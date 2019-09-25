package CompanyInterviews2020.Pinduoduo;

import java.util.Scanner;

/**
 * @author chenmengliang
 * @date 2019/9/25 15:08
 **/
public class Two {
    private static boolean[] planted;
    private static long res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n个点
        int n = scanner.nextInt();
        planted = new boolean[n+1];
        //m个区间
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {

            System.out.println(calcPlantedLength(scanner.nextInt(), scanner.nextInt()));
        }

    }

    /**
     * @param start 新区间的起止
     * @param end
     * @return
     */
    public static long calcPlantedLength(int start,int end){
        for (int i = start; i <= end; i++) {
            if (!planted[i]){
                planted[i] = true;
                res++;
            }
        }

        return res;
    }

}
