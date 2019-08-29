/**
 * @author Keith
 * @date 2019-08-29 16:26
 * 通过求解斐波那契数列 测试递归的用法
 * Fibonacci数列：
 *  1,1,2,3,5,8,13,21,34,55,89,...
 * 即F(1)=1;F(2)=1;F(n)=F(n-1)+F(n-2)
 **/
public class FibonacciTestRecurrence {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < 51; i++) {
            System.out.println(i+"  "+new FibonacciTestRecurrence().fibonacciByRecurrence(i));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("1~50用时："+(endTime-startTime));
    }

    /**
     *
     * @param index 第几个数字，从1开始
     * @return 第index个数，在数列中是几
     */
    private long fibonacciByRecurrence(long index){
        if (index <= 1){
            return 1;
        }
        if (index == 2){
            return 1;
        }
        return fibonacciByRecurrence(index-1)+fibonacciByRecurrence(index-2);


    }
}
