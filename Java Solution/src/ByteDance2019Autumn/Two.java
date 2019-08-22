package ByteDance2019Autumn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/11/2019 6:53 PM
 **/
public class Two {
    private void solution() {
        Scanner scanner = new Scanner(System.in);

        //明文的位数
        int N = scanner.nextInt();
        //加密时右移几位
        int K = scanner.nextInt();
        List<Integer> listMiwen = new ArrayList<Integer>();
        List<Integer> listMingwen = new ArrayList<>(N);
        String str = scanner.next();
        scanner.close();

        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            listMiwen.add(c[i] - '0');
        }

        for (int i = 0; i < N; i++) {
            if (i<K){
                int sum = listMiwen.get(i);
                for (int j = 0; j < i; j++) {
                    sum += listMingwen.get(j);
                }
                listMingwen.add(sum % 2);
            }
            else {
                int sum = listMiwen.get(i);
                for (int j = 0; j < K-1; j++) {
                    sum += listMingwen.get(j+i-K+1);
                }
                listMingwen.add(sum % 2);
            }
        }

        for (Integer i :
                listMingwen) {
            System.out.print(i);
        }


    }

    public static void main(String args[]) {
        new Two().solution();


    }
}
