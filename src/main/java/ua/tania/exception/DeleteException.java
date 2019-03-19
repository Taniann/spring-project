package ua.tania.exception;

/**
 * Created by Tania Nebesna on 18.03.2019
 */
public class DeleteException extends RuntimeException  {
    private static final long serialVersionUID = 1L;

    public DeleteException(String message) {
        super(message);
    }
}
