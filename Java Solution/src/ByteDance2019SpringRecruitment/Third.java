package ByteDance2019SpringRecruitment;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/10/2019 2:20 PM
 **/
public class Third {
    /**
     *  首先输入13个数值
     *  现在输入14个 测试 isHe() 方法
     */
    private final Integer N = 14;
    private ArrayList<Integer> arrayList = new ArrayList<>(N);

    private void solution(){
        //输入
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            int item = scanner.nextInt();
            //存入数组
            arrayList.add(item);

        }
        scanner.close();

        System.out.println(isHe(arrayList));






    }

    /**
     * 判断是否能
     * @param arrayList 有序的 序列
     * @return 能否胡牌
     */
    private boolean isHe(ArrayList<Integer> arrayList){

        if (arrayList.isEmpty()) {
            return true;
        }
        //第一个数字出现的次数

        //1. 选择雀头 ：选择两个 一样的数字


        //2. 找出顺子或刻子：在剩下的12个数字中找







        return false;
    }




    public static void main(String args[]) {
        new Third().solution();
    }
}