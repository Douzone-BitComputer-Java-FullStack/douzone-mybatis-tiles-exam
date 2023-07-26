package bit.edu.member.mapper;

import bit.edu.member.dto.LoginRequestDto;
import bit.edu.member.dto.MemberDto;
import bit.edu.member.dto.MemberModifyDto;
import bit.edu.member.dto.MemberRegisterDto;
import bit.edu.member.dto.UserDetailsDto;
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
public interface MemberMapper {

    boolean existByMemberId(@Param("memberId") String memberId);

    void createMember(MemberRegisterDto memberRegisterDto);

    List<MemberDto> findAllMember();

    MemberDto findMemberByUserSeq(@Param("userSeq") int userSeq);

    Optional<UserDetailsDto> findMemberByUserIdAndPassword(LoginRequestDto loginRequestDto);

    void deleteMemberByUserSeq(@Param("useSeq") int userSeq);

    void updateMemberByUserSeq(MemberModifyDto memberModifyDto);
}
