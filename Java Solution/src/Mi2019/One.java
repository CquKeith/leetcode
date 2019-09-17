package Mi2019;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-11 19:37
 **/
public class One {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String solution(String[] input) {
        StringBuilder ans = new StringBuilder(input.length);
        for (String line :
                input) {
            String [] list = line.split(" ");

            //先相加
            for (int i = 0; i < list.length; i++) {
                if ("".equals(list[i])){
                    continue;
                }
                if (i+1<list.length && list[i].equals(list[i+1])){
                    list[i] = String.valueOf(Integer.parseInt(list[i]) << 1);
                    list[i+1] = "0";
                    i++;
                }
            }


            //移动填补0
            for (int i = 0; i < list.length; i++) {
                int j = 1;
                while ("0".equals(list[i]) && i+j<list.length){
                    list[i] = list[i+j];
                    list[i+j] = "0";
                    j++;
                }
            }
            for (String item :
                    list) {
                ans.append(item).append(" ");
            }
            ans.append("\n");
        }

        return ans.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int size = 0;
        size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[size];
        String _input_item;
        for(int _input_i = 0; _input_i < size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }
        res = solution(_input);
        System.out.println(res);
    }
}
