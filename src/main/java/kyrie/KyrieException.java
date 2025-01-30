package kyrie;

/**
 * Represents an exception in Kyrie.
 */
public class KyrieException extends Exception {
    public static String errorSeparator = "\n\t__________________________ERROR_____________________________\n\t";
    
    /**
     * Constructor for KyrieException.
     * @param message The error message.
     */
    public KyrieException(String message) {
        super(errorSeparator + "There seems to be something wrong: " + message + errorSeparator);
    }
}