public class KyrieException extends Exception {
    public static String errorSeparator = "\n\t__________________________ERROR_____________________________\n\t";
    public KyrieException(String message) {
        super(errorSeparator + "There seems to be something wrong: " + message + errorSeparator);
    }
}