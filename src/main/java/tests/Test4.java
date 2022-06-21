package tests;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test4 {

    static int M;
    static int N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = Integer.parseInt(scanner.next());
        M = Integer.parseInt(scanner.next());

        char[][] arr = new char[N][M];
        Point start = null;

        for(int k = 0; k < N; k++){
            String line = scanner.next();
            char[] arr2 = line.toCharArray();
            for(int j = 0; j < M; j++){

                arr[k][j] = arr2[j];
                if(arr[k][j] == 'S') start = new Point(k,j);
            }

        }

        dAlgorithm(arr, start);

        for(int k = 0; k < N; k++){
            for(int j = 0; j < M; j++){
                System.out.print(arr[k][j]);
            }
            System.out.println();
        }


    }

    private static void dAlgorithm(char[][] arr, Point start){
        //Фронт
        Queue<PointAndCost> front = new PriorityQueue<>(
                Comparator.comparingInt(PointAndCost::getCost)
        );
        front.add(new PointAndCost(start, 0)); //Стартовая точка

        //Посещенные вершины
        Map<Point, PointAndCost> visited= new HashMap<>();
        visited.put(start, new PointAndCost(null, 0)); //Стартовая точка

        while(!front.isEmpty()){
            PointAndCost current = front.poll(); //Получение нода из границы

            for(Point next: neighbors(current.getPoint())){
                int newCost = arr[next.x][next.y]=='#'?20000:1;
                int nCost = visited.get(current.getPoint()).getCost() + newCost;  //Сумарная цена прохождения нода
                if(!visited.containsKey(next)||nCost < visited.get(next).getCost()){ //Проверка посещенных вершин и их стоимости
                    visited.put(next,new PointAndCost(current.getPoint(), nCost));
                    front.offer(new PointAndCost(next, nCost));
                }
            }
        }

        visited.forEach((k,v)->{
            if(arr[k.x][k.y]=='#')return;
            List<Point> neighbors = neighbors(k);
            for(Point p:neighbors){
                int costT = visited.get(k).getCost();
                int costS = visited.get(p).getCost();

                if(costT>costS){
                    arr[k.x][k.y] = testPos(k,p);
                }
            }
        });
    }

    static char testPos(Point t, Point s){
        if(t.x>s.x)return 'D';
        if(t.x<s.x)return 'U';
        if(t.y>s.y)return 'R';
        return 'L';
    }

    private static List<Point> neighbors(Point point){
        List<Point> neighbors = new ArrayList<>();

        //top left в данном случае практически бесполезно
        Point topNeighbors = point.getLocation();
        Point leftNeighbors = point.getLocation();

        topNeighbors.translate(0,-1);
        leftNeighbors.translate(-1,0);

        if(verificationPoint(topNeighbors))
            neighbors.add(topNeighbors);
        if(verificationPoint(leftNeighbors))
            neighbors.add(leftNeighbors);

        //bottom right
        Point bottomNeighbors = point.getLocation();
        Point rightNeighbors = point.getLocation();

        bottomNeighbors.translate(0,1);
        rightNeighbors.translate(1,0);

        if(verificationPoint(bottomNeighbors))
            neighbors.add(bottomNeighbors);
        if(verificationPoint(rightNeighbors))
            neighbors.add(rightNeighbors);



        return neighbors;
    }

    private static boolean verificationPoint(Point current){
        return current.x >= 0 && current.x <= N - 1 && current.y >= 0 && current.y <= M - 1;//верифицирует точку
    }

    public static class PointAndCost {
        Point point;
        Integer cost;

        public PointAndCost(Point point, Integer cost) {
            this.point = point;
            this.cost = cost;
        }

        public Point getPoint() {
            return point;
        }

        public Integer getCost() {
            return cost;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PointAndCost that = (PointAndCost) o;
            return Objects.equals(point, that.point) && Objects.equals(cost, that.cost);
        }

        @Override
        public int hashCode() {
            return Objects.hash(point, cost);
        }
    }
}
