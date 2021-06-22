package com.liuxinchi.filter;

import com.liuxinchi.pojo.User;
import com.liuxinchi.utils.Constant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession().getAttribute(Constant.USER_SESSION);
        if(user==null){
            resp.sendRedirect(req.getContextPath()+"/error.jsp");
        }
        else{
            filterChain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
