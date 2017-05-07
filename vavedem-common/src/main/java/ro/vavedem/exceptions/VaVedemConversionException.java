package ro.vavedem.exceptions;

/**
 * Created by CoruptiaUcide
 */
public class VaVedemConversionException extends VaVedemApiException {

    public VaVedemConversionException(String message) {
        super(message);
    }

    public VaVedemConversionException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
