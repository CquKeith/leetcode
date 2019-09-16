package Yuanfudao2019;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Keith
 * 顺时针打印数组
 **/
public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n行 m列
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        System.out.println(new One().printMatrix(nums).toString());
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> ans = new ArrayList<>(matrix.length*matrix[0].length);

        int row = 0,col = 0;
        int top = 0,bottom = matrix.length-1,right = matrix[0].length-1,left = 0;
        int count = 0;
        int numCount = matrix.length*matrix[0].length;
        while (count < numCount){

            row = top;
            col = left;
            //right 一行
            while (col <= right && count < numCount){
                ans.add(matrix[row][col++]);
                count++;
            }
            col = right;
            top++;

            //down 一列
            while (++row <= bottom && count < numCount){
                ans.add(matrix[row][col]);
                count++;
            }
            row = bottom;
            right--;

            //left 一行
            while (--col >= left && count < numCount){
                ans.add(matrix[row][col]);
                count++;
            }
            col = left;
            bottom--;

            //up 一列
            while (--row >= top && count < numCount){
                ans.add(matrix[row][col]);
                count++;
            }
            row = top;
            col++;
            left++;
        }

        return ans;
    }
}
