import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamsTask01 {

    public static void main(String[] args) {
        List<String> names = getData();
        Stream<String> stream = createStream(names);
        stream = filterStream(stream,"M");
        printFilteredNames(stream);
    }

    public static List<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Mary");
        list.add("John");
        list.add("Ryan");
        list.add("Joe");
        list.add("Kathy");
        list.add("Marley");
        list.add("Mickey");
        return list;
    }

    public static Stream<String> createStream(List<String> list) {
        return list.stream();
    }

    public static Stream<String> filterStream(Stream<String> names, String c) {
        return names.filter(name -> name.startsWith(c));
    }

    public static void printFilteredNames(Stream<String> filteredNames) {
        AtomicInteger count = new AtomicInteger(0);
        filteredNames.forEach(name -> System.out.println(count.incrementAndGet() + ") " + name));
        }
    }
