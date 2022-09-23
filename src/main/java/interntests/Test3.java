package interntests;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(test(a,b,c));
    }

    public static int test(int a, int b, int c){
        if(a>12) return 1;
        if(b>12) return 1;
        if(a==b) return 1;
        return 0;
    }
}
