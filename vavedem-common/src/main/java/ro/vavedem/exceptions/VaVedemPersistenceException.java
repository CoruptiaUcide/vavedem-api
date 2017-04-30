package ro.vavedem.exceptions;

/**
 * Created by CoruptiaUcide
 */
public class VaVedemPersistenceException extends VaVedemApiException {


    public VaVedemPersistenceException(String message) {
        super(message);
    }

    public VaVedemPersistenceException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
