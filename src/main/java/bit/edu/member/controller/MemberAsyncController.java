package bit.edu.member.controller;

import bit.edu.member.mapper.MemberMapper;
import bit.edu.member.service.MemberService;
import bit.edu.utils.CommonResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@RestController
@RequestMapping("/async/member")
@RequiredArgsConstructor
public class MemberAsyncController {

    private final MemberService memberService;

    @GetMapping("/duplicateCheck")
    public ResponseEntity<CommonResponseDto<Boolean>> memberDuplicateCheck(
        @RequestParam("memberId") String memberId
    ) {
        boolean result = memberService.existByMemberId(memberId);

        if (result) {
            return new ResponseEntity<>(new CommonResponseDto<>(false), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new CommonResponseDto<>(true), HttpStatus.OK);
    }
}
