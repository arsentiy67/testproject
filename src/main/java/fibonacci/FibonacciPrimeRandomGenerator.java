package fibonacci;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class FibonacciPrimeRandomGenerator {

    public static int generate() {
        List<Integer> list = fibbonachi(40).stream()
                .filter(FibonacciPrimeRandomGenerator::isPrime)
                .collect(Collectors.toList());
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    private static List<Integer> fibbonachi(int n) {
        Integer[] array = new Integer[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return Arrays.asList(array);
    }

    public static boolean isPrime(int number) {
        BigInteger bigInt = BigInteger.valueOf(number);
        return bigInt.isProbablePrime(100);
    }
}
