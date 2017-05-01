package ro.vavedem.exceptions;

/**
 * Created by CoruptiaUcide
 */
public class VaVedemNotFoundException extends VaVedemApiException  {


    public VaVedemNotFoundException(String message) {
        super(message);
    }

    public VaVedemNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
