package Exceptions;

public class BeanException extends Exception{
    public BeanException(String message) {
        super("Problème de Bean: " + message);
    }
}
