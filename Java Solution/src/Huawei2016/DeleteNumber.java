package Huawei2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/21/2019 16:12
 **/
public class DeleteNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            //数组的大小
            int n = scanner.nextInt();
            n = n > 1000 ? 999 : n;
            //存储数组的下标
            List<Integer> list = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            //轮流删除list中的数，实质上删除的是下标
            int idx = 0;
            while (list.size() > 1) {
                //循环找出 下次要删除的数的下标
                idx = (idx + 2) % list.size();
                list.remove(idx);
            }
            System.out.println(list.get(0));
        }


    }
}
