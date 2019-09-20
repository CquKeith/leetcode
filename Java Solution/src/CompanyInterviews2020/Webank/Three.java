package CompanyInterviews2020.Webank;

import java.util.Scanner;

/**
 * @author Keith
 * @date 2019-09-19 17:05
 * 图的深度优先遍历
 **/
public class Three {
    private static boolean[] visited;
    private static int n,m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        visited = new boolean[n+1];

        //初始化
        for (int i = 1; i <= n; i++) {
            visited[i] = false;
        }
        //边
        for (int i = 1; i <= m; i++) {

        }
        //入口
        int entry = scanner.nextInt();
        //出口
        int exit = scanner.nextInt();



        printResult();

        scanner.close();
    }
    private static void printResult(){
        for (int i = 1; i <= n ; i++) {
            if (visited[i] == false){
                System.out.print(i+" ");
            }
        }
    }
}
