import java.util.Map;
import java.util.stream.Collectors;

class RnaTranscription {

    private static Map<String, String> transcriptionMap = Map.of(
			"G", "C",
			"C", "G",
			"T", "A",
			"A", "U"
			);
	
	String transcribe(String dnaStrand) {
		return dnaStrand.chars().mapToObj(c -> transcriptionMap.get(String.valueOf((char) c))).collect(Collectors.joining());
    }

}
