package JavaBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Keith
 * @date 2019-09-17 13:40
 * 通过Arrays的stream ， 将一个int数组转成list
 **/
public class Int2List {
    public static void main(String[] args) {
        //List<Integer> list = Arrays.stream(new Integer[]{1,2,3}).collect(Collectors.toList());
        List<Integer> list = Arrays.stream(new int[]{1,2,3}).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}
