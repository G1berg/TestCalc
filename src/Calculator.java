import Exceptions.NonPositiveRomanNumberException;
import Exceptions.WrongImputStringFormatException;
import Exceptions.WrongNumberFormatException;

public class Calculator {
    public static final String NUMS = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
    public static int firstNum;
    public static int secondNum;
    public static int result;
    public static boolean isRomanNum = false;

    public static void calculate(String[] elements) {
        try {
            checkAndAssign(elements);
            process(elements[1].charAt(0));
            if (isRomanNum) {
                System.out.println(arabicToRomanConverter());
            } else {
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void checkAndAssign(String[] elements)
            throws WrongNumberFormatException, WrongImputStringFormatException, IllegalArgumentException {
        if (elements.length == 3) {
            if ("IVX".contains(elements[0].substring(0, 1)) &&
                    "IVX".contains(elements[2].substring(0, 1))) {
                firstNum = romanNum.valueOf(elements[0]).getValue();
                secondNum = romanNum.valueOf(elements[2]).getValue();
                isRomanNum = true;
            } else if (NUMS.contains(elements[0]) && NUMS.contains(elements[2])) {
                firstNum = Integer.parseInt(elements[0]);
                secondNum = Integer.parseInt(elements[2]);
            } else {
                throw new WrongNumberFormatException();
            }
        } else {
            if (elements.length > 3) {
                throw new WrongImputStringFormatException("Количество чисел и/или знаков должно быть меньше!");
            } else throw new WrongImputStringFormatException("Недостаточно чисел и/или знаков должно быть меньше!");
        }
    }

    private static String arabicToRomanConverter()
            throws NonPositiveRomanNumberException {
        if (result > 0) {
            int[] postions = {result / 100, result % 100 / 10, result % 10};
            String[] romanEquivalent = new String[3];
            for (int i = 0; i < 3; i++) {
                if (postions[i] <= 3) {
                    romanEquivalent[i] = "I".repeat(postions[i]);
                } else if (postions[i] == 4) {
                    romanEquivalent[i] = "IV";
                } else if (postions[i] <= 8) {
                    romanEquivalent[i] = "V" + "I".repeat(postions[i] - 5);
                } else {
                    romanEquivalent[i] = "IX";
                }
            }
            return romanEquivalent[0].replace('I', 'C') +
                    romanEquivalent[1].replace('X', 'C').
                            replace('V', 'L').replace('I', 'X') +
                    romanEquivalent[2];
        } else {
            throw new NonPositiveRomanNumberException();
        }
    }

    private static void process(char number) // Расчеты
            throws UnsupportedOperationException {
        switch (number) {
            case ('+') -> {
                result = firstNum + secondNum;
            }
            case ('-') -> {
                result = firstNum - secondNum;
            }
            case ('*') -> {
                result = firstNum * secondNum;
            }
            case ('/') -> {
                result = firstNum / secondNum;
            }
            default -> {
                throw new UnsupportedOperationException("Неверное вычесление!"); // Выброс исключения в несоответствии вычеслениях
            }
        }
    }
}