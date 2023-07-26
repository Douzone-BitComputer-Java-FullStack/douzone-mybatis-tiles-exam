package bit.edu.board.controller;

import bit.edu.board.dto.BoardDeleteRequestDto;
import bit.edu.board.dto.BoardRegisterDto;
import bit.edu.board.service.BoardService;
import bit.edu.utils.CommonResponseDto;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public String boardListForm(Model model) {
        model.addAttribute("boards", boardService.findAllBoard());
        return "boardList";
    }

    @GetMapping("/registerForm")
    public String boardRegisterForm() {

        return "boardRegister";
    }

    @PostMapping("/register")
    public String boardRegister(@ModelAttribute BoardRegisterDto boardRegisterDto,
                                @RequestParam(value = "uploadFile", required = false)
                                MultipartFile uploadFile)
        throws IOException {
        log.info("boardRegisterDto {}", boardRegisterDto);
        log.info("uploadFile {}", uploadFile);

        boardService.createBoard(boardRegisterDto, uploadFile);

        return "redirect:/boards";
    }

    @GetMapping("/{seq}")
    public String boardDetail(@PathVariable(value = "seq") int seq,
                              Model model) {
        model.addAttribute("board", boardService.findBoardBySeq(seq));

        return "boardDetail";
    }

    @ResponseBody
    @DeleteMapping("/{seq}")
    public ResponseEntity<CommonResponseDto> boardDelete(
        @PathVariable(value = "seq") int seq,
        @RequestBody BoardDeleteRequestDto boardDeleteRequestDto
    ) {

        boolean result = boardService.deleteBoardBySeq(boardDeleteRequestDto);

        if (!result) {
            return new ResponseEntity<>(new CommonResponseDto<>(result), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CommonResponseDto(result), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> displayImage(@PathVariable(value = "fileName") String fileName)
        throws IOException {
        File file = new File(System.getProperty("user.dir").concat("/images/").concat(fileName));
        HttpHeaders headers = new HttpHeaders();
        String mediaType = Files.probeContentType(file.toPath());
        headers.add("Content-Type", mediaType);

        return new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable(value = "fileName") String fileName)
        throws IOException {
        Path filePath = Paths.get(System.getProperty("user.dir").concat("/images/") + fileName);

        if (!filePath.toFile().isFile()) {
            throw new FileNotFoundException();
        }

        String mimeType = Files.probeContentType(filePath);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDisposition(ContentDisposition.builder("attachment")
            .filename(fileName, StandardCharsets.UTF_8)
            .build());
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, mimeType);
        Resource resource = new InputStreamResource(Files.newInputStream(filePath));

        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }
}
