package bit.edu.utils;

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
public class CommonResponseDto<T> {
    private T contnet;

}
