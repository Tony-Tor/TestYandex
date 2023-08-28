package attempt2;

import java.io.*;

public class Test1 {
    static int[] monthsToDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strings = reader.readLine().replaceAll("\\s+", " ").split(" ");

        long year1 = Integer.parseInt(strings[0]);
        long month1 = Integer.parseInt(strings[1]);
        long day1 = Integer.parseInt(strings[2]);
        long hour1 = Integer.parseInt(strings[3]);
        long min1 = Integer.parseInt(strings[4]);
        long sec1 = Integer.parseInt(strings[5]);

        String[] strings2 = reader.readLine().replaceAll("\\s+", " ").split(" ");

        long year2 = Integer.parseInt(strings2[0]);
        long month2 = Integer.parseInt(strings2[1]);
        long day2 = Integer.parseInt(strings2[2]);
        long hour2 = Integer.parseInt(strings2[3]);
        long min2 = Integer.parseInt(strings2[4]);
        long sec2 = Integer.parseInt(strings2[5]);

        long secRes1 = countSec(year1,month1,day1,hour1,min1,sec1);
        long secRes2 = countSec(year2,month2,day2,hour2,min2,sec2);

        long res = secRes2 - secRes1;

        long day = res/(24*60*60);
        long sec = res%(24*60*60);

        String result = day + " " + sec;

        writer.write(result);

        reader.close();
        writer.close();
    }

    public static long countSec(long year1,long month1,long day1,long hour1,long min1,long sec1){
        return sec1+60*min1+60*60*hour1+24*60*60*day1+24*60*60*countDayIntoMonth(month1)+24*60*60*365*year1;
    }

    public static long countDayIntoMonth(long num){
        int sum = 0;
        for(int i = 0;i<num-1;i++){
            sum += monthsToDay[i];
        }
        return sum;
    }

}
