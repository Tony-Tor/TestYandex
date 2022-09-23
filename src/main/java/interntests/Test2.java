package interntests;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(test(a,b,c));
    }

    public static int test(int a, int b, int c){
        int abs = Math.abs(c-b);
        int rightWay = abs - 1;
        int leftWay = a - (abs + 1);
        return rightWay<leftWay?rightWay:leftWay;
    }
}
