import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamsTask02 {

    public static void main(String[] args) {
        Map<String,Double> products = getData();
        products = filterData(products);
        printData(products);
    }

    public static Map<String,Double> getData() {
        Map<String,Double> products = new HashMap<>();
        products.put("Sugar",1.05);
        products.put("Coffee", 3.15);
        products.put("Milk",2.0);
        products.put("Juice",1.5);
        products.put("Cheese",0.95);
        products.put("Almond",1.95);
        products.put("Chocolate",2.95);
        return products;
    }

    public static Map<String,Double> filterData(Map<String,Double> products) {
        return products.entrySet().stream().filter(product -> product.getValue() <= 2.0).collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue));
    }

    public static void printData(Map<String,Double> products) {
        System.out.println("Products with values <= 2.0");
        AtomicInteger cnt = new AtomicInteger(0);
        products.forEach((key, value) -> System.out.println(cnt.incrementAndGet() + ") "+ key + " = " + value));
    }
}
