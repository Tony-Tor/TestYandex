package interntests2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i<10; i++){
            System.out.println(i);
            int a = scanner.nextInt();
            arr.add(a);
        }

        System.out.println(test(arr));
    }

    public static int test(List<Integer> arr){
        int max = 0;
        for(int i = 0; i < 10; i++){
            int current = arr.get(i);
            int rescount = 0;
            if(current == 1){
                int count = 0;
                for(int k = i;k<10;k++){
                    if(arr.get(k)==2) break;
                    count++;
                }
                int count2 = 0;
                for(int k = i;k>=0;k--){
                    if(arr.get(k)==2) break;
                    count2++;
                }
                rescount = count<count2?count:count2;
            }
            max=rescount>max?rescount:max;
        }
        return max;
    }
}
