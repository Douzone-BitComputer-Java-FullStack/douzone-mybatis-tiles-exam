package bit.edu.member.controller.admin;

import bit.edu.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Controller
@RequestMapping("/admin/members")
@RequiredArgsConstructor
public class MemberAdminController {

    private final MemberService memberService;

    @GetMapping
    public String adminMemberList(Model model) {
        model.addAttribute("members", memberService.findAllMember());
        return "/member/list";
    }

    @GetMapping("/{userSeq}")
    public String adminMemberDetails(@PathVariable(value = "userSeq") int userSeq,
                                     Model model) {
        model.addAttribute("member", memberService.findMemberByUserSeq(userSeq));

        return "/member/detail";
    }

    @PostMapping("/{userSeq}/delete")
    public String adminMemberDelete(@PathVariable(value = "userSeq") int userSeq) {
        memberService.deleteMemberByUserSeq(userSeq);

        return "redirect:/admin/members";
    }
}
