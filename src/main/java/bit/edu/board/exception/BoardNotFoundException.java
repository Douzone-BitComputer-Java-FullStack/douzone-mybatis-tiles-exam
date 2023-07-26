package bit.edu.board.exception;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class BoardNotFoundException extends RuntimeException {
    private static final String MESSAGE = "방명록을 찾을 수 없습니다.";

    public BoardNotFoundException() {
        super(MESSAGE);
    }
}
