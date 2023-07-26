package bit.edu.member.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
@ToString
public class MemberDto {
    private int userSeq;
    private String userId;
    private String userPhoneNumber;
    private String userStatus;
    private String userGrade;
    private int maxBook;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private LocalDateTime serviceStop;
}
