package Tencent2018SpringRecruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/16/2019 21:49
 **/
public class Two {
    private void solution(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextLong());
        }
        //两者都采用最优策略，也就是每次都抽的是当前最大的
        //先倒序排序
        Collections.sort(list,Collections.reverseOrder());
//        System.out.println(list);
        //相邻两个数的差
        long result = 0L;
        while (!list.isEmpty()){
            try {
                long niuniu = list.remove(0);
                result += niuniu;
                long yangyang = list.remove(0);
                result -= yangyang;
            }catch (Exception e){

            }
        }
        System.out.println(result);



    }


    public static void main(String args[]){
        new Two().solution();
    }
}
