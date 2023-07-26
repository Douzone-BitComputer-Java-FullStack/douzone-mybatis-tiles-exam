package bit.edu.board.service;

import bit.edu.board.dto.BoardDeleteRequestDto;
import bit.edu.board.dto.BoardDto;
import bit.edu.board.dto.BoardRegisterDto;
import bit.edu.book.dto.BookDto;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface BoardService {

    List<BoardDto> findAllBoard();

    BoardDto findBoardBySeq(int seq);

    void createBoard(BoardRegisterDto boardRegisterDto, MultipartFile uploadFile)
        throws IOException;

    boolean deleteBoardBySeq(BoardDeleteRequestDto boardDeleteRequestDto);

}
