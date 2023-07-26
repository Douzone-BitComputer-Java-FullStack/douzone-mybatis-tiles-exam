package bit.edu.board.dto;

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
public class BoardDto {
    private int seq;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime createDate;
    private String password;
    private String attatchData;
}
