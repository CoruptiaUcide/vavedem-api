package ro.vavedem.constants;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtils {

    // immutable and thread safe
    public static String getFormattedDateForDocs() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(AppConstants.dateWithMillis));
    }
}
