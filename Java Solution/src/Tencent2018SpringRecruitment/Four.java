package Tencent2018SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/17/2019 13:50
 **/
public class Four {

    public static void main(String args[]) {
        new Four().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        int targetLength = scanner.nextInt();
        int firstLength = scanner.nextInt(),firstNum = scanner.nextInt();
        int secondLength = scanner.nextInt(),secondNum = scanner.nextInt();
        scanner.close();


        //A长度的歌曲最多有多少个
        int firstMaxNum = targetLength / firstLength;

        long rlt = 0;
        for (int i = 0; i <= firstMaxNum; i++) {
            int leftLenth = targetLength - i*firstLength;
            if (leftLenth % secondLength == 0){
                rlt += calcCmn(firstNum,i)*calcCmn(secondNum,leftLenth/secondLength);
                rlt %= 1000000007;
            }
        }
        System.out.println(rlt);



    }

    /**
     * 计算Cmn
     * @param m
     * @param n
     * @return
     */
    private long calcCmn(int m,int n){
        long result = 1;
        //将C100 99这种改为C100 1
        if (n>m/2){
            n = m - n;
        }
        for (int i = 0; i < n; i++) {
            result *= m --;
            if (n>1){
                result /= n--;
            }
        }
        return result;
    }

}
