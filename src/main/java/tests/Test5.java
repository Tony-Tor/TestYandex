package tests;

import java.io.*;

public class Test5 {
    public static void main(String[] args) {

        int count_error = 0;
        int level = 0;
        boolean isFirst = true;



        int result = -1;

        int count = 1;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            int test = bufferedReader.read();
            while (test != -1) {
                if(test == '{') level++;
                if(test == '}') {
                    level--;
                    if(isFirst){
                        result = count;
                        isFirst = false;
                    }
                }
                if(level == -1){
                    count_error++;
                    level++;
                    if(count_error > 1) {
                        System.out.println(-1); return;
                    }
                }
                test = bufferedReader.read();
                count++;
                //System.out.print((int) test);
            }
            if(count_error == 0 && level == 0){
                System.out.println(-1); return;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //int count_error_2 = 0;
        int level_2 = 0;


        try(RandomAccessFile bufferedReader = new RandomAccessFile("input.txt", "r")) {
            for(long i = bufferedReader.length(); i >= 0; i--){
                bufferedReader.seek(i);
                char test = (char) bufferedReader.read();
                if(test == '{') level_2--;
                if(test == '}') level_2++;

                //System.out.print(test);

                if(level_2 == -1){
                    count_error++;
                    level_2++;
                    long temp = i+1;
                    //System.out.println(temp);
                     result = (int)temp;
                    if(count_error > 1){
                        System.out.println(-1); return;
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }
}
