import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class ResistorColorTrio {
    
    String label(String[] colors) {
		Supplier<Stream<String>> colorsStreamSupplier = () -> Arrays.stream(colors).map(String::toUpperCase);
		Collection<String> searchCollection = colorsStreamSupplier.get().limit(2).toList();
		List<String> resistorColors = Arrays.stream(ResistorColors.values()).map(Enum::name).toList();
		List<String> matchingElements = searchCollection.stream().filter(resistorColors::contains).toList();
		ToIntFunction<String> colorStringFunction = color -> ResistorColors.valueOf(color).getValue();
		StringBuffer resistorValueStringBuffer = new StringBuffer(matchingElements.stream()
				.map(color -> String.valueOf(ResistorColors.valueOf(color).getValue()))
				.collect(Collectors.joining()));
		int resistorValue = Integer.parseInt(resistorValueStringBuffer.toString());
		int zeroesToAdd = colorsStreamSupplier.get().skip(2).mapToInt(colorStringFunction).findFirst().orElse(0);
		IntStream.range(0, zeroesToAdd).forEach(x -> resistorValueStringBuffer.append("0"));
		int totalZeroes = (int) String.valueOf(resistorValueStringBuffer).chars().filter(ch -> ch == '0').count();
		int foundExponent = Arrays.stream(MetricPrefix.values())
				.map(MetricPrefix::getValue)
				.sorted((a, b) -> Integer.compare(b, a))
				.filter(prefix -> totalZeroes >= prefix)
				.findFirst()
				.orElse(0);

		String resistorValueString = resistorValue == 0 ? "0": resistorValueStringBuffer.toString();
		
		return resistorValueString.substring(0, resistorValueString.length() - foundExponent).replaceFirst("^0+(?!$)", "") + " " + 
				Arrays.stream(MetricPrefix.values())
				.filter(prefix -> prefix.getValue() == foundExponent)
				.map(MetricPrefix::name).findFirst().orElse("").toLowerCase() + "ohms";
    }

    enum MetricPrefix {
    	KILO(3), MEGA(6), GIGA(9);
    
    	private int value;
    
    	MetricPrefix(int value) {
    		this.value = value;
    	}
    
    	public int getValue() {
    		return value;
    	}
    }

    enum ResistorColors {
    	BLACK(0), BROWN(1), RED(2), ORANGE(3), YELLOW(4), GREEN(5), BLUE(6), VIOLET(7), GREY(8), WHITE(9);
    
    	private int value;
    
    	ResistorColors(int value) {
    		this.value = value;
    	}
    
    	public int getValue() {
    		return value;
    	}
    }
    
}
