package kyrie;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
    private static final DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("hh:mma, MMM dd yyyy");
    private LocalDateTime dateTime;

    public DateTime(String dateTime) throws KyrieException {
        try {
            this.dateTime = LocalDateTime.parse(dateTime, formatter);
        } catch (Exception e) {
            throw new KyrieException("Invalid date/time format. Please use the format dd/MM/yyyy HHmm");
        }
    }

    public String toInputFormatString() {
        return this.dateTime.format(formatter);
    }

    public String toString() {
        return this.dateTime.format(outputFormatter);
    }
}