import java.util.Scanner;

public class TestCalc {
public static void main (String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите данные -> ");
    String[] input = scanner.nextLine().split(" ");
    Calculator.calculate(input);
    }
}
