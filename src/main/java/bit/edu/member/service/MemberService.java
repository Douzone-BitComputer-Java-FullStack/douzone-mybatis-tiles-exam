package bit.edu.member.service;

import bit.edu.member.dto.LoginRequestDto;
import bit.edu.member.dto.MemberDto;
import bit.edu.member.dto.MemberModifyDto;
import bit.edu.member.dto.MemberRegisterDto;
import bit.edu.member.dto.UserDetailsDto;
import java.util.List;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface MemberService {

    boolean existByMemberId(String memberId);

    void createMember(MemberRegisterDto memberRegisterDto);

    List<MemberDto> findAllMember();

    MemberDto findMemberByUserSeq(int userSeq);

    UserDetailsDto loginUser(LoginRequestDto loginRequestDto);

    void deleteMemberByUserSeq(int userSeq);

    void modifyMemberByUserSeq(MemberModifyDto memberModifyDto);
}
