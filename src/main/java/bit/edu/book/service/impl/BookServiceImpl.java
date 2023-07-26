package bit.edu.book.service.impl;

import bit.edu.book.dto.BookDto;
import bit.edu.book.mapper.BookMapper;
import bit.edu.book.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    @Override
    public List<BookDto> findAllBook() {
        return bookMapper.findAllBook();
    }
}
