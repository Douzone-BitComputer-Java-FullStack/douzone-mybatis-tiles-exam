package bit.edu.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDeleteRequestDto {

    private String seq;
    private String password;
}
