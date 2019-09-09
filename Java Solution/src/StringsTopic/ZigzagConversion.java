package StringsTopic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenmengliang
 * @date 2019/9/9 09:50
 * [6. Z 字形变换](https://leetcode-cn.com/problems/zigzag-conversion/)
 **/
public class ZigzagConversion {
    public static void main(String[] args) {

        //System.out.println(new ZigzagConversion().convert("LEETCODEISHIRING",3));
        //System.out.println(new ZigzagConversion().convert("LEETCODEISHIRING",4));
        System.out.println(new ZigzagConversion().convert("AB",1));
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     *
     * 0                    2(k-1)
     * 1                ... 2k-1
     * 2            k+2     2k
     * 3        k+1         ...
     * ...  k
     * k-1                  3(k-1)
     * 每当行号是0或者k-1的时候，换方向
     */
    public String convert(String s, int numRows) {
        if (s.length() <= 1 || numRows == 1){
            return s;
        }

        int curRow = 0;
        //是否是往下的方向 true代表往上走
        boolean downDirection = false;

        //这里定义list的大小，取了numRows和s.length()的最小值，主要是防止 s的长度<numRows 因为这样的还 下面foreach的第一句就异常了
        //比如 "ABCDEFG" 2行的问题
        List<StringBuilder> stringBuilderList = new ArrayList<>(Math.min(numRows,s.length()));
        for (int i = 0; i < numRows; i++) {
            stringBuilderList.add(new StringBuilder());
        }

        for (char ch :
                s.toCharArray()) {
            stringBuilderList.get(curRow).append(ch);

            if (curRow == 0 || curRow == numRows - 1){
                downDirection = !downDirection;
            }

            curRow += downDirection?1:-1;

        }
        //将所有行 按行连在一起
        StringBuilder allStrings = new StringBuilder();
        for (StringBuilder sb :
                stringBuilderList) {
            allStrings.append(sb);
        }
        return allStrings.toString();

    }

}
