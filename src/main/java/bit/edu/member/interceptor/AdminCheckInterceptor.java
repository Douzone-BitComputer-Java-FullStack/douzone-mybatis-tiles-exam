package bit.edu.member.interceptor;

import bit.edu.member.dto.UserDetailsDto;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class AdminCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(false);

        if (Objects.isNull(session)) {
            response.sendRedirect("/");
            return true;
        }

        UserDetailsDto userDetailsDto = (UserDetailsDto) session.getAttribute("user");

        if (Objects.isNull(userDetailsDto)) {
            response.sendRedirect("/");
            return true;
        }

        if (!userDetailsDto.getIsAdmin()) {
            response.sendRedirect("/");
        }

        return true;
    }
}
