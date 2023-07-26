package bit.edu.member.exception;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class MemberNotFoundException extends RuntimeException {
    private static final String MESSAGE = "해당 회원을 찾을 수 없습니다.";

    public MemberNotFoundException() {
        super(MESSAGE);
    }
}
