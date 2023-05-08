package Exceptions;

public class WrongImputStringFormatException extends Exception{
    public WrongImputStringFormatException(String format) {
        super(format);
    }
}
