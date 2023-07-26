package bit.edu.board.service.impl;

import bit.edu.board.dto.BoardDeleteRequestDto;
import bit.edu.board.dto.BoardDto;
import bit.edu.board.dto.BoardRegisterDto;
import bit.edu.board.exception.BoardNotFoundException;
import bit.edu.board.exception.NotAcceptableFileException;
import bit.edu.board.mapper.BoardMapper;
import bit.edu.board.service.BoardService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    private final List<String> acceptableFileExtensions =
        List.of("image/gif", "image/jpg", "image/jpeg", "image/png");

    private static final String UPLOAD_DIR = System.getProperty("user.dir").concat("/images");

    @Override
    public List<BoardDto> findAllBoard() {
        return boardMapper.findAllBoard();
    }

    @Override
    public BoardDto findBoardBySeq(int seq) {
        return boardMapper.findBoardBySeq(seq)
            .orElseThrow(BoardNotFoundException::new);
    }

    @Override
    public void createBoard(BoardRegisterDto boardRegisterDto, MultipartFile uploadFile)
        throws IOException {

        if (Objects.isNull(uploadFile) || uploadFile.isEmpty()) {
            log.info("uploadFIle {}" ,uploadFile);
            boardMapper.createBoard(boardRegisterDto);
        } else {
            acceptableFileCheck(uploadFile);
            String saveFileName = saveFile(uploadFile);
            boardRegisterDto.setAttatchData(saveFileName);
            boardMapper.createBoard(boardRegisterDto);
        }
    }

    @Override
    public boolean deleteBoardBySeq(BoardDeleteRequestDto boardDeleteRequestDto) {
        return boardMapper.deleteBoardBySeq(boardDeleteRequestDto) > 0;
    }

    private String saveFile(MultipartFile uploadFiles) throws IOException {
        File file = new File(UPLOAD_DIR);
        file.mkdirs();
        String fileName = UUID.randomUUID() + "_" + uploadFiles.getOriginalFilename();
        uploadFiles.transferTo(Paths.get(UPLOAD_DIR + "/" + fileName));
        return fileName;
    }

    private void acceptableFileCheck(MultipartFile file) {
        if (!file.isEmpty() && !acceptableFileExtensions.contains(file.getContentType())) {
            throw new NotAcceptableFileException();
        }
    }
}
