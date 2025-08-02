import java.util.Arrays;
import java.util.stream.Collectors;

class ResistorColorDuo {
    int value(String[] colors) {
        return Integer.parseInt(Arrays.stream(colors).limit(2).map(color -> String.valueOf(ResistorColors.valueOf(color.toUpperCase()).ordinal())).collect(Collectors.joining()));
    }
}

enum ResistorColors {
    BLACK(0),
    BROWN(1),
    RED(2),
    ORANGE(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6),
    VIOLET(7),
    GREY(8),
    WHITE(9);

    private int value;

    ResistorColors(int value) {
        this.value = value;
    }
}