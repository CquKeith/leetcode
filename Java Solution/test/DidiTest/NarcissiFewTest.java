package DidiTest;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/26/2019 10:42
 **/
public class NarcissiFewTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            boolean hasNar = false;
            for (int idx = left; idx <= right; idx++) {
                //拆解每一位
                int sum = 0;
                int num = idx;
                while (num!=0){
                    int temp = num %10;
                    num /= 10;
                    sum += temp*temp*temp;
                }
                if (sum == idx){
                    hasNar = true;
                    System.out.print(idx+" ");
                }
            }
            if (hasNar){
                System.out.println();
            }else {
                System.out.println("no");
            }
        }
    }

}
