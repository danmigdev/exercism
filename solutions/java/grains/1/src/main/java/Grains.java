import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square < 1 || square > 64) {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
        
        return BigInteger.valueOf(2).pow(square - 1);
    }

    BigInteger grainsOnBoard() {
        return IntStream.range(1, 64 + 1)
            .mapToObj(this::grainsOnSquare)
        	.reduce(BigInteger.valueOf(0), (a, b) -> a.add(b));
    }

}
