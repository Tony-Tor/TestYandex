package interntests2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.next();

        System.out.println(test(s));
    }

    public static int test(String s){
        String rev = new StringBuilder(s).reverse().toString();
        char[] arr1 = s.toCharArray();
        char[] arr2 = rev.toCharArray();
        int cost = 0;
        for(int i = arr1.length/2; i<arr1.length; i++){
            if(arr1[i]!=arr2[i])cost++;
        }
        return cost;
    }
}
