package CompanyInterviews2020.Tencent2019AutumnRecruitment.Three;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Keith
 * @date 2019-09-20 21:50
 * 还没来得及测试
 **/
public class Five {
    private static Set<Long> setA,setB;
    private Iterator<Long> iterator;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        setA = new HashSet<>(n);
        setB = new HashSet<>(n);

        for (int i = 0; i < n; i++) {
            setA.add(scanner.nextLong());
        }
        for (int i = 0; i < n; i++) {
            setB.add(scanner.nextLong());
        }

        System.out.println(solution());
    }
    private static long solution(){
        Set<Long> setSum = new HashSet<>();
        for (long a :
                setA) {
            for (long b:
                 setB) {
                setSum.add(a+b);
            }
        }
        Iterator<Long> iterator = setSum.iterator();
        long first = iterator.next();
        if (setSum.size() == 1){
            return first;
        }
        long ans = first;
        while (iterator.hasNext()){
            ans ^= iterator.next();
        }
        return ans;
    }
}
