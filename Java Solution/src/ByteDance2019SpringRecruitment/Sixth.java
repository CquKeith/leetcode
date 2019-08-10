package ByteDance2019SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/10/2019 5:25 PM
 **/
public class Sixth {

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        //输入花的钱
        int N = scanner.nextInt();

        //用1024的钱买价格是N的商品后的零钱
        int change = 1024 - N;
        //零钱硬币种类
        int[] changeArray = {64,16,4,1};
        //找零的硬币数
        int result = 0;
        for (int i = 0; i < changeArray.length && change!=0; i++) {
           result += change/changeArray[i];
           change %= changeArray[i];
        }
        System.out.println(result);


    }



    public static void main(String args[]) {
        new Sixth().solution();
    }


}
