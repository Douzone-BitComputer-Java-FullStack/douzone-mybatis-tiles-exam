package bit.edu.book.mapper;

import bit.edu.book.dto.BookDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface BookMapper {

    List<BookDto> findAllBook();
}
