package Exceptions;

public class NonPositiveRomanNumberException extends Exception{
    public NonPositiveRomanNumberException() {
        super ("В римской системе счисления нет чисел меньше 1!");
    }
}
