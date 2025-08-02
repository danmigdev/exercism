import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    private static final int BOARD_SIZE = 64;
    
    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > BOARD_SIZE) {
            throw new IllegalArgumentException("square must be between 1 and " + BOARD_SIZE);
        }
        
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        return BigInteger.valueOf(2).pow(BOARD_SIZE).subtract(BigInteger.valueOf(1));
    }

}
