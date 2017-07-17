package com.lh.web.filter;

import com.lh.web.util.security.UserDetail;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LH 2446059046@qq.com on 2017/7/17.
 */

@Order(1)
@WebFilter(urlPatterns = "/*")
public class UserInfoFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetail) {
            String username = ((UserDetail) principal).getUsername();
            session.setAttribute("myname", username);
        }

        filterChain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
