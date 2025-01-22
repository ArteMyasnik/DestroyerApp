package learn.destroyer.program.exceptions.checked;

public class ItemIsAlreadyBroken extends Exception {
    public ItemIsAlreadyBroken(String message) {
        super(message);
    }
}
