package interntests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();
        scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(test(b));
    }

    static List<Integer> arr;
    public static int test(String b){
        arr = Arrays.stream(b.split(" ")).mapToInt(i-> Integer.parseInt(i)).boxed().collect(Collectors.toList());
        int max = arr.get(arr.size()-1);
        int min = arr.get(0);
        int center = (max+min)/2;
        int result;
        while (true){

            long point0 = getCost(center);
            long point1 = getCost(center-1);
            long point2 = getCost(center+1);

            //System.out.println(min +  " "  + center + " " + max);
            if(point0>point1){
                //System.out.println(isUp(center));
                max = center;
                center = (max+min)/2;

            } else if(point0>point2){
                //System.out.println(isDown(center));
                min = center;
                center = (max+min)/2;
            } else {
                result = center;
                break;
            }
        }

        return result;
    }

    public static long getCost(int pos){
        return arr.stream().mapToInt(i->i).map(i->Math.abs(pos-i)).sum();
    }
}
