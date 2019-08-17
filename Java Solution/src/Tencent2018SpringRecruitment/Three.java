package Tencent2018SpringRecruitment;

import java.util.Scanner;

/**
 * @author Keith
 * @date 8/17/2019 12:39
 **/
public class Three {

    private void solution() {

        Scanner scanner = new Scanner(System.in);
        //出差天数
        int n = scanner.nextInt();
        //巧克力数量
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(searchFirstDayMaxChocolate(m,n));
    }

    /**
     * 使用二分法查找
     * @param num 巧克力数量
     * @param day 总共要吃多少天
     * @return 第一天最多吃多少
     */
    private int searchFirstDayMaxChocolate(int num, int day){
        //第一天最少吃1个，最多吃num-day+1个（以后的day-1天，每天吃1个）
        int left = 1;
        int right = num - day + 1;

        if (num == day) {
            return 1;
        }

        int mid = (left + right)/2;
        while (left <= right){
            int sum = sumChocolate(mid,day);
            if (sum == num){
                return mid;
            }else if (sum > num){
                right = mid-1;
            }else {
                left = mid+1;
            }
            mid = (left + right)/2;
        }
        return mid;

    }

    /**
     *
     * @param firstDayNum 第一天吃的量
     * @param day 吃多少天
     * @return 这几天一共吃的量
     */
    private int sumChocolate(int firstDayNum, int day){
        int sum = 0;
        //当天吃的量
        int currentDayNum = firstDayNum;
        for (int i = 0; i < day; i++) {
            sum += currentDayNum;
            currentDayNum = (int) Math.ceil((double)currentDayNum/2);
            //如果下一次 只能吃一个了，说明剩下的day-(i+1)天，每天也只能吃一个了
            if (currentDayNum == 1){
                sum += day - (i+1);
                break;
            }
        }
        return sum;



    }


    public static void main(String args[]) {
        new Three().solution();
    }
}
