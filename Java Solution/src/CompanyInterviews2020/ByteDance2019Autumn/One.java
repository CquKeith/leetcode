package CompanyInterviews2020.ByteDance2019Autumn;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Keith
 * @date 8/11/2019 6:52 PM
 **/
public class One {
    private void solution(){
        Scanner scanner = new Scanner(System.in);

        //闹钟数量
        int N = scanner.nextInt();
        ArrayList<Time> arrayList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arrayList.add(new Time(scanner.nextInt(),scanner.nextInt()));
        }
        //从起床到教室的时间
        int X = scanner.nextInt();
        //上课时间
        Time timeClass = new Time(scanner.nextInt(),scanner.nextInt());

        //最晚起床时间
        Time timeGetup = new Time();
        for (int i = 0; i < arrayList.size(); i++) {
            Time t = new Time(arrayList.get(i).hour,arrayList.get(i).min);
            t.min += X;
            t.hour += t.min / 60;
            t.min %= 60;
            //当前时间可以不迟到
            if (t.toDouble() <= timeClass.toDouble()){
                //更新最晚的时间
                Time temp = arrayList.get(i);
                if ((timeGetup.hour == -1) || (timeGetup.toDouble() < temp.toDouble())){
                    timeGetup = temp;
                }
            }

        }
        timeGetup.print();


        scanner.close();
    }



    public static void main(String args[]){
        new One().solution();
    }
}
class Time{

     Integer hour;
     Integer min;

    Time(Integer hour, Integer min) {
        this.hour = hour;
        this.min = min;
    }
    Time(){
        this.min=-1;
        this.hour=-1;
    }


    public void print(){
        System.out.print(hour+" ");
        System.out.println(min);
    }
    public double toDouble(){
        return hour + (double)min/60;
    }

}
