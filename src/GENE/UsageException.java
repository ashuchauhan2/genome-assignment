package GENE;

public class UsageException extends Exception {
    public UsageException() {
        super("ERROR: Genones are required to be of equal length.");
    }

    public UsageException(String message) {
        super(message);
    }
}
