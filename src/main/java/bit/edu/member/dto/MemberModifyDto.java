package bit.edu.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/

@Getter
@AllArgsConstructor
public class MemberModifyDto {

    private int userSeq;
    private String phoneNumber;
}
