package CompanyInterviews2020.iQiyi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Keith
 * 18%
 **/
public class Two {
    private static  int[] workArray;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 1 << n;
        int m = scanner.nextInt();
        int[] array = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            array[i] = scanner.nextInt();
        }
        workArray = new int[cnt >> 1];

        for (int i = 0; i < m; i++) {
            array[scanner.nextInt()-1] = scanner.nextInt();
            System.out.println(getVSolution(array,n));
        }
    }

    /**
     * 计算v的值
     * @param nums
     * @param n 执行多少次之后返回
     * @return
     */
    private static int getVSolution(int[] nums,int n){

        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 2){
            return nums[0] | nums[1];
        }
        if (nums.length == 4){
            return (nums[0] | nums[1]) ^ (nums[2] | nums[3]);
        }

        int currentLength = nums.length >> 1;
        boolean first = true;

        while (currentLength > 1){
            //或
            for (int i = 0,j=0; i < currentLength ; i++,j+=2) {
                if (first){
                    workArray[i] = nums[j] | nums[j+1];
                }else {
                    workArray[i] = workArray[j] | workArray[j+1];
                }
            }
            currentLength /= 2;

            first = false;

            //异或
            for (int i = 0,j=0; i < currentLength; i++,j+=2) {
                workArray[i] = workArray[j] ^ workArray[j+1];

            }
        }

        return workArray[0];
    }
}
