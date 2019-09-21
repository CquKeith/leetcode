package CompanyInterviews2020.NetEase;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-21 15:56
 **/
public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int examplesNum = scanner.nextInt();
        for (int i = 0; i < examplesNum; i++) {
            System.out.println(findMinOperations(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
        }
    }
    private static int findMinOperations(int A,int B,int p,int q){
        int ans = 0;
        //需要弥补的最小数
        int delat = B - A;

        if (p >= delat){
            return 1;
        }
        while (p < delat){
            p *= q;
            ans++;
        }

        return ans+1;
    }
}
