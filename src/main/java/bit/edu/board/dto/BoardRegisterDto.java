package bit.edu.board.dto;

import java.time.LocalDateTime;
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
public class BoardRegisterDto {
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createDate;
    private String password;
    private String attatchData;
    public BoardRegisterDto(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createDate = LocalDateTime.now();
        this.password = password;
        this.attatchData = null;
    }

    public void setAttatchData(String attatchData) {
        this.attatchData = attatchData;
    }
}
