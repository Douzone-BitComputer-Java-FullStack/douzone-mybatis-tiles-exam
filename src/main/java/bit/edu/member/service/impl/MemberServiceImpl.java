package bit.edu.member.service.impl;

import bit.edu.member.dto.LoginRequestDto;
import bit.edu.member.dto.MemberDto;
import bit.edu.member.dto.MemberModifyDto;
import bit.edu.member.dto.MemberRegisterDto;
import bit.edu.member.dto.UserDetailsDto;
import bit.edu.member.exception.MemberNotFoundException;
import bit.edu.member.mapper.MemberMapper;
import bit.edu.member.service.MemberService;
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
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    private static final String ADMIN = "admin";
    @Override
    public boolean existByMemberId(String memberId) {
        return memberMapper.existByMemberId(memberId);
    }

    @Override
    public void createMember(MemberRegisterDto memberRegisterDto) {
        memberMapper.createMember(memberRegisterDto);
    }

    @Override
    public List<MemberDto> findAllMember() {
        return memberMapper.findAllMember();
    }

    @Override
    public MemberDto findMemberByUserSeq(int userSeq) {
        return memberMapper.findMemberByUserSeq(userSeq);
    }

    @Override
    public UserDetailsDto loginUser(LoginRequestDto loginRequestDto) {
        UserDetailsDto userDetailsDto = memberMapper.findMemberByUserIdAndPassword(loginRequestDto)
            .orElseThrow(MemberNotFoundException::new);

        if (userDetailsDto.getUserId().equals(ADMIN)) {
            userDetailsDto.setAdmin(true);
        }

        return userDetailsDto;
    }

    @Override
    public void deleteMemberByUserSeq(int userSeq) {
        memberMapper.deleteMemberByUserSeq(userSeq);
    }

    @Override
    public void modifyMemberByUserSeq(MemberModifyDto memberModifyDto) {
        memberMapper.updateMemberByUserSeq(memberModifyDto);
    }
}
