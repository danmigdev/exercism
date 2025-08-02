import java.util.Map;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private String letters;
    
    ParallelLetterFrequency(String letters) {
        this.letters = letters;
    }

    Map<Integer, Integer> letterCounts() {
        return letters
                .toLowerCase()
                .replaceAll("[^a-zA-Z]", "")
                .chars()
                .parallel()
                .boxed()
                .collect(Collectors.groupingByConcurrent(x -> x, Collectors.summingInt(e -> 1)));
    }

}