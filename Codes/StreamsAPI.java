package Codes;
import java.util.stream.*;
@SuppressWarnings("all")
public class StreamsAPI {
    public static void main(String args[])
    {
        int numbers[] = {4, 1, 13, 90, 16, 2, 0};
        //Minimum
        int min = IntStream.of(numbers).min().getAsInt();
        //Maximum
        int max = IntStream.of(numbers).max().getAsInt();
        //Sum
        int sum = IntStream.of(numbers).sum();
        //Average
        double avg = IntStream.of(numbers).average().getAsDouble();

        // Printing Smallest 3 distict numbers
        IntStream.of(numbers)
                 .distinct()
                 .sorted()
                 .limit(3)
                 .forEach(System.out::println);
        
    }
}
