package ByteDance2019SpringRecruitment;

import java.util.*;

/**
 * @author Keith
 * @date 8/10/2019 2:20 PM
 **/
public class Third {
    //首先输入13个数值
    private final Integer N = 14;
    private ArrayList<Integer> arrayList = new ArrayList<>(N);
    private Map<Integer,Integer> map = new HashMap<>();

    private void solution(){
        //输入
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            int item = scanner.nextInt();
            //存入数组
            arrayList.add(item);
            //存入map，可以统计出现的频率
            if (!map.containsKey(item)){
                map.put(item,1);
            }else {
                map.put(item,map.get(item)+1);
            }
        }
        scanner.close();







    }

    /**
     * 判断是否能胡牌
     * @return
     */
    private boolean canHu(){
        boolean isHu = false;

        //1. 选择雀头 ：选择两个 一样的数字

        //2. 找出顺子或刻子：在剩下的12个数字中找


        return isHu;
    }




    public static void main(String args[]) {
        new Third().solution();
    }
}