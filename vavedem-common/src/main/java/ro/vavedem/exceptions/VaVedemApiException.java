package ro.vavedem.exceptions;

/**
 * Created by CoruptiaUcide
 */
public class VaVedemApiException extends RuntimeException {


    public VaVedemApiException(String message) {
        super(message);
    }

    public VaVedemApiException(String message, Throwable throwable) {
        super(message, throwable);
    }


}
