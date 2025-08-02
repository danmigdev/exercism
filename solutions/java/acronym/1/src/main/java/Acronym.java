import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Acronym {

    private List<String> words;
    
    Acronym(String phrase) {
        phrase = phrase.replace("_", "");
        words = Arrays.stream(phrase.split(" ")).flatMap((x) -> Arrays.stream(x.split("-"))).toList();
    }

    String get() {
        return words.stream().map(c -> String.valueOf((char) c.charAt(0)).toUpperCase()).collect(Collectors.joining());
    }

}
