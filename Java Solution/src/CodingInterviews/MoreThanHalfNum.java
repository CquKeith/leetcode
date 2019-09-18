package CodingInterviews;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenmengliang
 * @date 2019/9/18 11:01
 **/
public class MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum().moreThanHalfNumSolution(new int[]{1}));
    }

    public int moreThanHalfNumSolution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = array.length / 2;
        for (int item :
                array) {
            if (map.containsKey(item)) {
                int fre = map.get(item) + 1;
                if (fre > length){
                    return item;
                }
                map.put(item, fre);
            } else {
                map.put(item, 1);
                if (1 > length){
                    return item;
                }
            }
        }

        return 0;

    }

}
