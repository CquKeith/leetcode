package Company2019InNowcoder.iQiyi2018Autumn.Three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author chenmengliang
 * @date 2019/9/17 21:50
 *  *  爱奇艺2018秋季校招java工程师（第三场）
 * DNA序列
 * https://www.nowcoder.com/questionTerminal/ab900f183e054c6d8769f2df977223b5?orderByHotValue=1&difficulty=00100&mutiTagIds=643_639_640&page=20&onlyReference=false
 **/
public class DNASerial {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String dna = scanner.nextLine();
        scanner.close();

        //求dna 长度i 的字串有多少种
        for (int i = 1; i <= dna.length(); i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j + i <= dna.length(); j++) {
                set.add(dna.substring(j,j+i));
            }
            //长度i 的 set 的size应该是4^i = 2^ 2i;
            if (set.size() < 1<<(i<<1)){
                System.out.println(i);
                return;
            }
            //System.out.println(set.toString());
        }

    }

}