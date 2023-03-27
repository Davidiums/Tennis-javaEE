package Exceptions;

public class DaoException extends Exception{
    public DaoException(String message) {
        super("Probleme de DAO: " + message);
    }
}
