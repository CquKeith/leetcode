import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Keith
 * @date 2019-08-29 16:26
 * 通过求解斐波那契数列 测试递归的用法
 * Fibonacci数列：
 *  1,1,2,3,5,8,13,21,34,55,89,...
 * 即F(0)=0;F(1)=1;F(n)=F(n-1)+F(n-2)
 **/
public class FibonacciTestDynamicProgramming {

    private Map<Long,Long> map = new HashMap<>();
    private List<Long> dp = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 51; i++) {
            System.out.println(i+"  "+new FibonacciTestDynamicProgramming().fibonacciByDymaicProgrammingWithNoRecurence(i));
//            System.out.println(i+"  "+new FibonacciTestDynamicProgramming().fibonacciByDymaicProgramming(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("1~50用时："+(endTime-startTime));
    }

    /**
     *
     * @param index 第几个数字，从1开始
     * @return 第index个数，在数列中是几
     */
    private long fibonacciByDymaicProgramming(long index){

        if (map.containsKey(index)){
            return map.get(index);
        }
        if (index == 0){
            map.put(0L,0L);
            return 0;
        }
        if (index == 1){
            map.put(1L,1L);
            return 1;
        }

        long temp = fibonacciByDymaicProgramming(index-1)+fibonacciByDymaicProgramming(index-2);
        map.put(index,temp);
        return temp;

    }

    /**
     *
     * @param index 第几个数字，从1开始
     * @return 第index个数，在数列中是几
     * 不使用递归的斐波那契数列求解----自底向上求解
     */
    private long fibonacciByDymaicProgrammingWithNoRecurence(long index){
        long ans = 0;

        dp.add(0,0L);
        dp.add(1,1L);
        for (int i = 2; i <= index; i++) {
            dp.add(i,dp.get(i-1)+dp.get(i-2));
        }

        return dp.get((int) index);
    }

}
