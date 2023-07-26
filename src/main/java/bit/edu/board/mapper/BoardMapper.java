package bit.edu.board.mapper;

import bit.edu.board.dto.BoardDeleteRequestDto;
import bit.edu.board.dto.BoardDto;
import bit.edu.board.dto.BoardRegisterDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface BoardMapper {

    List<BoardDto> findAllBoard();
    Optional<BoardDto> findBoardBySeq(@Param("seq") int seq);
    void createBoard(BoardRegisterDto boardRegisterDto);
    int deleteBoardBySeq(BoardDeleteRequestDto boardDeleteRequestDto);


}
