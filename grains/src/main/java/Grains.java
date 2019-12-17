import java.math.BigInteger;

class Grains {

    BigInteger grainsOnSquare(final int square) {
        if (square <= 0 || square > 64)
            throw new IllegalArgumentException("square must be between 1 and 64");
        BigInteger doubleNumber = new BigInteger("2");
        if (square == 1)
            return new BigInteger("1");
        else
            return grainsOnSquare(square - 1).multiply(doubleNumber);

    }

    BigInteger grainsOnBoard() {
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= 64; i++)
            sum = sum.add(grainsOnSquare(i));
        return sum;
    }

}
