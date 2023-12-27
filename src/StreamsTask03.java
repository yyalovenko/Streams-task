import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class StreamsTask03 {
    public static void main(String[] args) {
        Map<String,Integer> temperatures = getData();
        temperatures = filterAndPrintData(temperatures);
        printData(temperatures);
    }

    public static Map<String,Integer> getData() {
        Map<String,Integer> temperatures = new HashMap<>();
        temperatures.put("Mon",8);
        temperatures.put("Tue", 10);
        temperatures.put("Wed",12);
        temperatures.put("Thu",15);
        temperatures.put("Fri",13);
        temperatures.put("Sat",11);
        temperatures.put("Sun",12);
        return temperatures;
    }

    public static Map<String,Integer> filterAndPrintData (Map<String,Integer> temperatures) {
       return temperatures.entrySet().stream().filter(day -> day.getValue() >= 10 && day.getValue() <= 13).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry:: getValue));
    }

    public static void printData(Map<String,Integer> temperatures) {
        System.out.println("Days with temperatures between 10 and 13 degrees");
        AtomicInteger cnt = new AtomicInteger(0);
        temperatures.forEach((key, value) -> System.out.println(cnt.incrementAndGet() + ") "+ key + ": " + value + " deg"));
    }

}
