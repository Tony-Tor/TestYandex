package attempt2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int countPerson = Integer.parseInt(reader.readLine());

        StringTokenizer lang = new StringTokenizer(reader.readLine(), " ");
        StringTokenizer tree = new StringTokenizer(reader.readLine(), " ");

        for(int i = 0; i < countPerson; i++){

        }

        while (tree.hasMoreTokens()){
            int token = Integer.parseInt(tree.nextToken());

        }


        writer.write(" ");

        reader.close();
        writer.close();

        System.out.println();
    }

    public static int test(int a, int b, int c){
        return 0;
    }

    public static class Node{
        public String lang;
        public int id;
        public List<Node> children;
        public Node parent;

        public Node(String lang, int id) {
            this.lang = lang;
            this.id = id;
            this.children = new ArrayList<>();
            this.parent = null;
        }
    }
}
