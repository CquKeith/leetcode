import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/9/17 10:37
 **/
public class Zhongxing1 {
    public static void main(String[] args) {
        System.out.println(new Zhongxing1().sortedMarksList(6,new int[]{33,44,22,77,66,55},3,new int[]{11,88,99}));
    }
    public List<Integer> sortedMarksList(int num1, int[] firstGroupList, int num2,int[]secondGroupList){
        List<Integer> ans = new ArrayList<>(num1+num2);
        for (int item :
                firstGroupList) {
            ans.add(item);
        }
        for (int item :
                secondGroupList) {
            ans.add(item);
        }

        Collections.sort(ans);
        return ans;
    }
}
