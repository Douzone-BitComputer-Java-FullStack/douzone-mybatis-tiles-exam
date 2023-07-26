package bit.edu.member.controller;

import bit.edu.member.dto.LoginRequestDto;
import bit.edu.member.dto.MemberDto;
import bit.edu.member.dto.MemberModifyDto;
import bit.edu.member.dto.MemberRegisterDto;
import bit.edu.member.dto.UserDetailsDto;
import bit.edu.member.service.MemberService;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "main";
    }

    @GetMapping("/member/registerForm")
    public String memberRegisterForm() {
        return "/member/register";
    }

    @PostMapping("/member/register")
    public String memberRegister(@ModelAttribute MemberRegisterDto memberRegisterDto) {
        memberService.createMember(memberRegisterDto);

        return "redirect:/member/loginForm";
    }

    @GetMapping("/member/loginForm")
    public String loginForm() {
        return "/member/loginForm";
    }

    @PostMapping("/member/login")
    public String login(@ModelAttribute LoginRequestDto loginRequestDto,
                        HttpServletRequest request) {
        UserDetailsDto userDetailsDto = memberService.loginUser(loginRequestDto);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", userDetailsDto);

        log.info("userDetialsDto {}", userDetailsDto);

        return "redirect:/boards";
    }

    @GetMapping("/member/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (Objects.nonNull(session)) {
            session.invalidate();
        }

        return "redirect:/";
    }

    @GetMapping("/member/modifyForm")
    public String memberModifyForm() {
        return "/member/modify";
    }

    @PostMapping("/member/modify")
    public String memberModify(@ModelAttribute MemberModifyDto memberModifyDto) {
        memberService.modifyMemberByUserSeq(memberModifyDto);
        return "redirect:/main";
    }
}
