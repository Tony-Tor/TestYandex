package interntests;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(test(a,b,c));
    }

    public static int test(int a, int b, int c){
        switch (b){
            case 0: {
                if(a!=0){
                    return 3;
                } else {
                    return c;
                }
            }
            case 1: {
                return c;
            }
            case 4: {
                if(a!=0){
                    return 3;
                } else {
                    return 4;
                }
            }
            case 6: {
                return 0;
            }
            case 7: {
                return 1;
            }
            default:{
                return b;
            }
        }
    }
}
