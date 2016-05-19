import java.util.*;

public class BiggestPrimeNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().replaceAll("([()\\s]+)", " ").trim().split(" ");
        int[] numbers = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        Arrays.sort(numbers);
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (isPrime(numbers[i]) && !primeNumbers.contains(numbers[i])) {
                primeNumbers.add(numbers[i]);
            }

            if (primeNumbers.size() == 3) {
                break;
            }
        }

        if (primeNumbers.size() < 3) {
            System.out.println("No");
        } else {
            int sum = 0;
            for (Integer primeNumber : primeNumbers) {
                sum += primeNumber;
            }

            System.out.println(sum);
        }

    }

    private static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        } else if (number % 2 == 0 || number <= 1) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
