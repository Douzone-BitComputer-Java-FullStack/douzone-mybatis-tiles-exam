package bit.edu.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
@ToString
public class MemberRegisterDto {

    private String userId;
    private String password;
    private String phone;
}
