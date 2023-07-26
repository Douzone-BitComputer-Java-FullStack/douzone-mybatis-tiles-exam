package bit.edu.board.exception;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class NotAcceptableFileException extends RuntimeException {

    private static final String MESSAGE = "허가되지 않는 파일 타입입니다.";

    public NotAcceptableFileException() {
        super(MESSAGE);
    }
}
