import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class ResistorColorTrio {

   	private static Map<String, Integer> colorToValueMap = Map.of(
			"black", 0,
			"brown", 1,
			"red", 2,
			"orange", 3,
			"yellow", 4,
			"green", 5,
			"blue", 6,
			"violet", 7,
			"grey", 8,
			"white", 9
			);
	
	private static Map<Integer, String> valuesToPrefixMap = Map.of(
			0, "",
			3, "kilo",
			6, "mega",
			9, "giga"
			);
    
    String label(String[] colors) {
        String ohmString = Arrays.stream(colors)
				.limit(2)
				.map(colorToValueMap::get)
				.toList()
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining());
		
		int zeroes = Arrays.stream(colors)
				.skip(2)
				.map(colorToValueMap::get)
				.findFirst()
				.orElse(0);
		
		long ohms = Long.parseLong(ohmString) * (long) Math.pow(10,  zeroes);

		int key = valuesToPrefixMap.keySet().stream()
				.sorted((a, b) -> b.compareTo(a))
				.limit(3)
				.filter(x -> ohms >= Math.pow(10,  x))
				.findFirst()
				.orElse(0);
		
		String result = String.valueOf((int) (key == 0 ? ohms : ohms / Math.pow(10, key)));
		
		return result + " " + valuesToPrefixMap.get(key) + "ohms";
    }
    
}
