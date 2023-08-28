package interntests2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int a = scanner.nextInt();
        while (a!=0){
            arr.add(a);
            a = scanner.nextInt();
        }

        System.out.println(test(arr));
    }

    public static int test(List<Integer> arr){
        int max = 0;
        int count = 0;
        for(int i:arr){
            if(i>max){
                count = 0;
                max = i;
            }
            if(i == max)count++;
        }
        return count;
    }
}
