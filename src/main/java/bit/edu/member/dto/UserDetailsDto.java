package bit.edu.member.dto;

import lombok.Getter;
import lombok.ToString;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@ToString
public class UserDetailsDto {
    private int userSeq;
    private String userId;

    private boolean isAdmin;

    public UserDetailsDto(int userSeq, String userId) {
        this.userSeq = userSeq;
        this.userId = userId;
        this.isAdmin = false;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
