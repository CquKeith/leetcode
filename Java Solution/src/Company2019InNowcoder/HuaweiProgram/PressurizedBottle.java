package Company2019InNowcoder.HuaweiProgram;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/20/2019 21:57
 **/
public class PressurizedBottle {
    public static void main(String[] args) {
        new PressurizedBottle().solution();
    }
    private void solution(){
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNextInt()){
                int n = scanner.nextInt();
                if (n == 0){
                    break;
                }
                System.out.println(n/2);
            }
        }catch (Exception e){

        }

        scanner.close();
    }

    /**
     * 3个空瓶换一瓶汽水
     * 可以先借一瓶汽水，喝完之后再还
     * @param emptyBottleNum 空瓶数
     * @return 最多换多少瓶汽水
     * 算法：
     *      贪心
     */
    private int calcMaxBottle(int emptyBottleNum){
//        int ans = 0;
//        while (emptyBottleNum>=3){
//            //尽可能多的去将空瓶换出去
//            int  temp = emptyBottleNum/3;
//            ans += temp;
//            emptyBottleNum %= 3;
//            //换来的汽水 喝完之后又是一个空瓶
//            emptyBottleNum += temp;
//        }
//        //剩两个的话 可以借一瓶，然后喝完之后再还
//        if (emptyBottleNum == 2){
//            ans ++;
//        }
//
//
//
//        return ans;
        return emptyBottleNum / 2;
    }
}
