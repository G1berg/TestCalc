package Exceptions;

public class WrongNumberFormatException extends Exception {
    public WrongNumberFormatException() {
        super ("Используются одновременно разные системы счисления!");
    }
}
