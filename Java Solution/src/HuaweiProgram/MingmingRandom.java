package HuaweiProgram;

import java.util.*;

/**
 * @author Keith
 * @date 8/21/2019 10:30
 * 华为第二题
 * 牛客地址：https://www.nowcoder.com/questionTerminal/3245215fffb84b7b81285493eae92ff0
 **/
public class MingmingRandom {
    public static void main(String[] args) {
        new MingmingRandom().solution();
    }

    private void solution() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<Integer> setArray = new HashSet<Integer>();
            //一边输入一边去重
            for (int i = 0; i < n; i++) {
                setArray.add(scanner.nextInt());
            }
            List<Integer> listArray = new ArrayList<>(setArray.size());
            listArray.addAll(setArray);

            //排序
            Collections.sort(listArray);
            for (Integer item :
                    listArray) {
                System.out.println(item);
            }
        }
    }
}
