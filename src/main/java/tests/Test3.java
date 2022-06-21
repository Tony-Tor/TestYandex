package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Test3 {

    static class Product{
        long id;
        String name;
        long price;
        LocalDate date;

        public Product(long id, String name, long price, LocalDate date) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.date = date;
        }

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return id == product.id && price == product.price && Objects.equals(name, product.name) && Objects.equals(date, product.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, price, date);
        }

        @Override
        public String toString() {
            return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"price\":" + price + ",\"date\":\"" + date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + "\"}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Object> filters = new HashMap<>();
        filters.put("NAME_CONTAINS", "");
        filters.put("PRICE_GREATER_THAN", 0);
        filters.put("PRICE_LESS_THAN",2147483647);
        filters.put("DATE_BEFORE", LocalDate.of(2070,12,31));
        filters.put("DATE_AFTER", LocalDate.of(1970,1,1));

        List<Product> products = new ArrayList<>();

        String JSON = scanner.nextLine();
        String line = scanner.nextLine();
        int k = 1;
        while (!line.equals("")){

            if(k==5)break;
            String[] data = line.split("\\s+");
            //System.out.println(data[0]);
            //System.out.println(data[1]);
            switch (data[0]){
                case "NAME_CONTAINS": {
                    filters.put("NAME_CONTAINS", data[1]);
                    break;
                }
                case "PRICE_GREATER_THAN": {
                    filters.put("PRICE_GREATER_THAN", Integer.valueOf(data[1]));
                    break;
                }
                case "PRICE_LESS_THAN": {
                    filters.put("PRICE_LESS_THAN", Integer.valueOf(data[1]));
                    break;
                }
                case "DATE_BEFORE": {
                    filters.put("DATE_BEFORE", LocalDate.parse(data[1],DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    break;
                }
                case "DATE_AFTER": {
                    filters.put("DATE_AFTER", LocalDate.parse(data[1],DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    break;
                }
            }
            try {
                line = scanner.nextLine();
            } catch (NoSuchElementException e) {

            }
            k++;
        }

        JSONArray jsonArray = (JSONArray) JSONValue.parse(JSON);

        for(int i = 0; i < jsonArray.size(); i++){
            JSONObject data = (JSONObject) jsonArray.get(i);
            //System.out.println(data);
            long id = (Long) data.get("id");
            String name = (String) data.get("name");
            long price = (Long)data.get("price");
            LocalDate date = LocalDate.parse((String) data.get("date"),DateTimeFormatter.ofPattern("dd.MM.yyyy"));

            Product product = new Product(id,name,price,date);
            products.add(product);
        }

        products = products.stream().filter(product -> {

            String str = ((String)filters.get("NAME_CONTAINS")).toLowerCase();
            int minPrice = (Integer)filters.get("PRICE_GREATER_THAN");
            int maxPrice = (Integer)filters.get("PRICE_LESS_THAN");
            LocalDate beforeDate = (LocalDate) filters.get("DATE_BEFORE");
            LocalDate afterDate = (LocalDate) filters.get("DATE_AFTER");

            if(!product.name.toLowerCase().contains(str)){return false;}
            if(product.price>maxPrice||product.price<minPrice){return false;}
            if(!(product.date.isBefore(beforeDate)&&product.date.isAfter(afterDate))){return false;}
            return true;
        }).collect(Collectors.toList());

        System.out.print("[" + products.get(0));

        for(int i = 1; i < products.size(); i++){
            System.out.print(","+products.get(i));
        }

        System.out.println("]");
    }
}
