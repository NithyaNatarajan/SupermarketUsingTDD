package exception;

public class InvalidArticleConfigurationException extends RuntimeException {
    public InvalidArticleConfigurationException(String message) {
        super(message);
    }
}