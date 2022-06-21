package tests;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String Q = scanner.next();
        String S = scanner.next();

        char[] Qarr = Q.toCharArray();
        char[] Sarr = S.toCharArray();

        String[] Rarr = new String[Qarr.length];

        for(int i = 0; i<S.length();i++){
            if(Qarr[i] == Sarr[i]) {
                Rarr[i] = "correct";
            }
        }

        Map<String, Integer> Rmap = new HashMap<>();

        for(int i = 0; i<S.length();i++){
            if(Rarr[i]==null) {
                Rmap.computeIfPresent(Qarr[i]+"",(f,v)-> v + 1);
                Rmap.putIfAbsent(Qarr[i]+"", 1);
            }
        }

        for(int i = 0; i<S.length();i++){
            if(Rarr[i]==null) {
                if(Rmap.get(Sarr[i]+"")!=null&&Rmap.get(Sarr[i]+"")>0){
                    Rarr[i] = "present";
                    Rmap.computeIfPresent(Sarr[i]+"",(f,v)-> v - 1);
                } else {
                    Rarr[i] = "absent";
                }
            }
        }

        for(int i = 0; i<S.length();i++){
            System.out.println(Rarr[i]);
        }
    }
}
