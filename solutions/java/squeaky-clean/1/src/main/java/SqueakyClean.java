import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class SqueakyClean {
    
    static String clean(String identifier) {
        String newIdentifier = identifier;

        newIdentifier = newIdentifier
                .replaceAll(" ", "_")
                .replaceAll("[\u0000-\u001f\u007F]", "CTRL");

        if (newIdentifier.contains("-")) {
            newIdentifier = newIdentifier.split("-")[0] + Arrays.stream(newIdentifier.split("-"))
                    .skip(1)
                    .map(s -> s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1))
                    .collect(Collectors.joining());
        }
        
        newIdentifier = newIdentifier.chars()
                .filter(c -> c == '_' || Character.isLetter(c))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        newIdentifier = Pattern.compile("[α-ω]")
                .splitAsStream(newIdentifier)
                .collect(Collectors.joining());

        return newIdentifier;
    }
    
}
