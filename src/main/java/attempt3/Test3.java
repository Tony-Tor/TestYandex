package attempt3;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        double n = Integer.parseInt(reader.readLine());

        List<Node> allNode = new ArrayList<>();
        Node root = new Node();
        allNode.add(root);


        for (int i = 0; i < n; i++){
            int k = Integer.parseInt(reader.readLine());
            Node node = new Node();
            Node remove = allNode.get(k);
            node.setParent(remove);
            allNode.add(node);
        }

        int index = 0;
        int max = 0;
        for (int i = 0; i < allNode.size(); i++){
            Node node = allNode.get(i);
            if(node.children.size()==0){
                way = 0;
                node.upPass((node1) -> way = way + 1);
                if(max<way){
                    max = way;
                    index = i;
                }
            }
        }

        writer.write("" + index);

        reader.close();
        writer.close();
    }

    static int way = 0;

    public static class Node {

        private Node parent = null;
        private List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public void upPass(Consumer<Node> consumer){
            Node current = this;
            while(current != null){
                consumer.accept(current);
                current = current.parent;
            }
        }

        public void addChild(Node node){
            children.add(node);
            node.parent = this;
        }

        public void setParent(Node parent) {
            parent.addChild(this);
        }
    }
}
