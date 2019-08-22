package Huawei2019Autumn;

import java.util.*;

/**
 * @author Keith
 * @date 8/21/2019 18:44
 **/
public class Two {
    //保存所有的质数
    // value 是否是质数
    private final Map<Long,Boolean> allMap = new HashMap<>();

    public static void main(String[] args) {
        new Two().solution();
    }


    private void solution() {
        Scanner scanner = new Scanner(System.in);

        List<Long> list = getZhishu(scanner.nextLong(),scanner.nextLong());
        scanner.close();

        long sumGe=0,sumShi=0;
        for (Long item :
                list) {
            sumGe += item%10;
            sumShi += item/10%10;
        }
        System.out.println((int)Math.min(sumGe,sumShi));

    }

    /**
     * [start,end)之间的所有质数
     * @param start
     * @param end
     * @return
     */
    private List<Long> getZhishu(long start, long end){
        List<Long> list = new ArrayList<>();

        for (long i = start; i < end; i++) {
            if (isPrim(i)){
                list.add(i);
            }
        }
        return list;

    }

    /**
     * 判断n是否是质数
     * @param n
     * @return
     */
    private boolean isPrim(long n){
        boolean ans = true;
        if (allMap.containsKey(n)){
            ans = allMap.get(n);
        }else {
            //判断是不是质数
            for (int i = 2; i < n; i++) {
                if (n % i == 0){
                    ans = false;
                    break;
                }
            }
        }

       if (ans){
           for (int i = 1; i < 10; i++) {
               allMap.put(n*i,false);
           }
       }
        return ans;
    }
}
