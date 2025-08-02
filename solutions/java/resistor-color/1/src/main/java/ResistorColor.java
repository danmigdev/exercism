import java.util.Arrays;

class ResistorColor {
    
    int colorCode(String color) {
        return ResistorColors.valueOf(color.toUpperCase()).getValue();
    }

    String[] colors() {
        return Arrays.stream(ResistorColors.values()).map((x) -> x.name().toLowerCase()).toArray(String[]::new);
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

    private final int value;

    ResistorColors(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
