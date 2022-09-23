package interntests;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(test(a,b,c));
    }

    public static int test(int d, int x, int y){
        if(y+x-d<=0&&x>=0&&y>=0)return 0;
        else {
            int result;
            double len1 = lenToPoint(x,y,0,0);
            double len2 = lenToPoint(x,y,d,0);
            double len3 = lenToPoint(x,y,0,d);

            result = len1<=len2?len1<=len3?1:3:len2<=len3?2:3;

            return result;
        }
    }

    public static double lenToPoint(int x0, int y0, int x1, int y1){
        int x = Math.abs(x0-x1);
        int y = Math.abs(y0-y1);
        return Math.sqrt(x*x+y*y);
    }
}
