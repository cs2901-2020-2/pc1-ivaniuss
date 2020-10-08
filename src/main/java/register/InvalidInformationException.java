package register;
public class InvalidInformationException extends Exception {
    private static final long serialVersionUID = 1L;
    InvalidInformationException(String message) {
        super(message);
    }
}
