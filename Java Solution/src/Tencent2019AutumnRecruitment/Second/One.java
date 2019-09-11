package Tencent2019AutumnRecruitment.Second;


import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-01 19:59
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfBox = scanner.nextInt();
        int numOfKey = scanner.nextInt();

        int evenBox=0,oddBox=0,evenKey=0,oddKey=0;

        for (int i = 0; i < numOfBox; i++) {
            long item = scanner.nextLong();
            if (item%2 == 0){
                evenBox++;
            }else {
                oddBox++;
            }
        }
        for (int i = 0; i < numOfKey; i++) {
            long item = scanner.nextLong();
            if (item%2 == 0){
                evenKey++;
            }else {
                oddKey++;
            }
        }

        System.out.println(Math.min(evenBox,oddKey)+Math.min(oddBox,evenKey));


    }




}
