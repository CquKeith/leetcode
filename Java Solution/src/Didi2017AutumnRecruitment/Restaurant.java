package Didi2017AutumnRecruitment;

import java.util.*;

/**
 * @author Keith
 * @date 8/27/2019 17:42
 **/
public class Restaurant {

    public static void main(String[] args) {

//        System.out.println(binarySearchMinimumNotLessThan(13,new int[]{1,4,7,12}));

        Scanner scanner = new Scanner(System.in);
        // 桌子数量
        int numDesk = scanner.nextInt();
        // 客人数量 单位：批
        int numComsumer = scanner.nextInt();

        // 每张桌子最多可以坐多少人
        List<Integer> deskCapacity = new ArrayList<>(numDesk);
        for (int i = 0; i < numDesk; i++) {
            deskCapacity.add(scanner.nextInt());
        }

        //每批客人的属性
        List<MyConsumer> consumers = new ArrayList<MyConsumer>(numComsumer);
        for (int i = 0; i < numComsumer; i++) {
            consumers.add(new MyConsumer(scanner.nextInt(), scanner.nextInt()));
        }
        scanner.close();

        //Solution
        long maxMoney = 0L;
        //先排序
        //桌子 容量升序
        Collections.sort(deskCapacity);
        //顾客按照消费金额降序
        Comparator<MyConsumer> consumerComparator = new Comparator<MyConsumer>() {
            @Override
            public int compare(MyConsumer o1, MyConsumer o2) {
                return o2.money - o1.money;
            }
        };
        consumers.sort(consumerComparator);


        //
//        System.out.println(deskCapacity.toString());
//        System.out.println(consumers.toString());

        //依次安排顾客
        for (MyConsumer c :
                consumers) {
            //找最小的能够满足该批客户的桌子
            //依次遍历 会超过本题的时间限制
            //对已经有序的序列，最有效的就是折半查找了

            int index = binarySearchMinimumNotLessThan(c.num,deskCapacity);
            //没有足够的位置安排本桌人 就放弃
            if (index > deskCapacity.size()-1){
                continue;
            }
            maxMoney += c.money;
//            System.out.println("桌子容量"+deskCapacity.get(index) + "客人："+c.toString());

            deskCapacity.remove(index);
        }
        System.out.println(maxMoney);

    }

    /**
     * 通过折半查找 找出array中大于等于target的最小的数
     * @param array
     * @return 返回满足要求的第一个index
     */
    private static int binarySearchMinimumNotLessThan(int target, List<Integer> array){
        int left = 0;
        int right = array.size() - 1;
        int mid;
        while (left <= right){
            mid = (left + right) >> 1;
            if (array.get(mid) >= target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    private static int binarySearchMinimumNotLessThan(int target, int[] array){
        List<Integer> list = new ArrayList<>(array.length);
        for (int a :
                array) {
            list.add(a);
        }
        return binarySearchMinimumNotLessThan(target,list);
    }

    }

class MyConsumer {
    /**
     * 该批客人有多少人
     */
    int num;
    /**
     * 该批客人的消费金额
     */
    int money;

    public MyConsumer(int num, int money) {
        this.num = num;
        this.money = money;
    }

    @Override
    public String toString() {
        return "MyConsumer{" +
                "num=" + num +
                ", money=" + money +
                '}';
    }
}
