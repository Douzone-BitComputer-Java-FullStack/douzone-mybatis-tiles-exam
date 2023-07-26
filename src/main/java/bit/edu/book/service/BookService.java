package bit.edu.book.service;

import bit.edu.book.dto.BookDto;
import java.util.List;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface BookService {

    List<BookDto> findAllBook();
}
